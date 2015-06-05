Date.prototype.getWeek = function() {
  var onejan = new Date(this.getFullYear(), 0, 1);
  return Math.ceil((((this - onejan) / 86400000) + onejan.getDay() + 1) / 7);
};

var today = new Date();
var weekno = today.getWeek();

function trans(left, top) {
  return 'translate(' + left + ', ' + top + ')';
};

function barChart(period, metric, projectId, containerId, legendText) {

  var data = [];
  var startDate = new Date();

  if (period === 'Y') {
    startDate.setDate(startDate.getDate() - 365);
  } else if (period === 'S') {
    startDate.setDate(startDate.getDate() - 180);
  } else if (period === 'Q') {
    startDate.setDate(startDate.getDate() - 90);
  } else if (period === 'M') {
    startDate.setDate(startDate.getDate() - 30);
  } else if (period === 'W') {
    startDate.setDate(startDate.getDate() - 7);
  } else {
    // default
    startDate.setDate(startDate.getDate() - 365);
  }

  var queryParams = [
    'resource=' + projectId,
    'metrics=' + metric,
    'fromDateTime=' + startDate.toISOString()
  ];
  var query = queryParams.join('&');
  var url = baseUrl + '/api/timemachine/index?' + query

  $.get(url, function(r) {
    r[0].cells.forEach(function(cell) {
      var p = {
        date: new Date(cell.d),
        value: cell.v[0]
      };
      data.push(p);
    });

    var filtereddata = [];

    if (period === 'Y' || period === 'S' || period === 'Q') {
      var previousP = null;
      for (var i = 0; i < data.length; i++) {
        var currentP = data[i];

        if (previousP != null) {
          if (currentP.date.getMonth() > previousP.date.getMonth() || currentP.date.getYear() > previousP.date.getYear()) {
            filtereddata.push(previousP);
            previousP = currentP;
          }
        } else {
          previousP = currentP;
        }

        if (i === (data.length - 1)) {
          filtereddata.push(currentP);
        }
      }
    } else {
      var previousP = null;
      for (var i = 0; i < data.length; i++) {
        var currentP = data[i];

        if (previousP != null) {
          if (currentP.date.getWeek() > previousP.date.getWeek() || currentP.date.getYear() > previousP.date.getYear()) {
            filtereddata.push(previousP);
            previousP = currentP;
          }
        } else {
          previousP = currentP;
        }

        if (i === (data.length - 1)) {
          filtereddata.push(currentP);
        }
      }
    }
    data = filtereddata;

    var margin = {
        top: 20,
        right: 20,
        bottom: 70,
        left: 80
      },
      width = d3.select("#" + containerId).property('offsetWidth') - margin.left - margin.right,
      height = 300 - margin.top - margin.bottom;

    var x = d3.scale.ordinal().rangeRoundBands([0, width], .05);
    var y = d3.scale.linear().range([height, 0]);

    var xAxis = d3.svg.axis()
      .scale(x)
      .orient("bottom")
      .tickFormat(d3.time.format("%Y-%m"));

    var yAxis = d3.svg.axis()
      .scale(y)
      .orient("left")
      .ticks(10);

    d3.select("#" + containerId).html("");

    var svg = d3.select("#" + containerId).append("svg")
      .attr("width", width + margin.left + margin.right)
      .attr("height", height + margin.top + margin.bottom)
      .append("g")
      .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

    x.domain(data.map(function(d) {
      return d.date;
    }));
    y.domain([0, d3.max(data, function(d) {
      return d.value;
    })]);

    svg.append("g")
      .attr("class", "x axis")
      .attr("transform", "translate(0," + height + ")")
      .call(xAxis)
      .selectAll("text")
      .style("text-anchor", "end")
      .attr("dx", "-.8em")
      .attr("dy", "-.55em")
      .attr("transform", "rotate(-90)");

    svg.append("g")
      .attr("class", "y axis")
      .call(yAxis)
      .append("text")
      .attr("transform", "rotate(0)")
      .attr("y", -18)
      .attr("x", 8)
      .attr("dy", ".71em")
      .style("text-anchor", "end")
      .text(legendText);

    var barEnter = svg.selectAll("bar")
      .data(data)
      .enter();

    barEnter.append("rect")
      .style("fill", "steelblue")
      .attr("x", function(d) {
        return x(d.date);
      })
      .attr("width", x.rangeBand())
      .attr("y", function(d) {
        return y(d.value);
      })
      .attr("height", function(d) {
        return height - y(d.value);
      });

    barEnter.append("text")
      .attr('transform', function(d) {
        return trans(x(d.date) + x.rangeBand() / 2, y(d.value) - 3);
      })
      .style('text-anchor', 'middle')
      .text(function(d) {
        return d.value;
      });

  });
};