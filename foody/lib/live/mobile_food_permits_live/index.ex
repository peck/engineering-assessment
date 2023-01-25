defmodule FoodyWeb.MobileFoodPermitsLive.Index do
  use FoodyWeb, :live_view

  alias Foody.MobileFoodPermitETS

  def mount(params, _session, socket) do
    {:ok,
     assign(socket,
       permits: MobileFoodPermitETS.list()
     )}
  end
end
