defmodule FoodyWeb.PageController do
  use FoodyWeb, :controller

  def index(conn, _params) do
    render(conn, "index.html")
  end
end
