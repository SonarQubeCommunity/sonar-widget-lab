require "base64"

class Api::LogoController < ApplicationController
  def getLogo
    project = Project.by_key(params[:project]);
    
    logo_data = project.last_snapshot.measure('logo_data').data;
    logo_ext = project.last_snapshot.measure('logo_ext').data;
    
    send_data(Base64.decode64(logo_data), :filename => "logo." + logo_ext, :type => "application/" + logo_ext);
  end
end