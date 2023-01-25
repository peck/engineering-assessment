defmodule Foody.Application do
  # See https://hexdocs.pm/elixir/Application.html
  # for more information on OTP Applications
  @moduledoc false

  use Application

  @impl true
  def start(_type, _args) do
    children = [
      # Start the Ecto repository
      Foody.Repo,
      # Start the Telemetry supervisor
      FoodyWeb.Telemetry,
      # Start the PubSub system
      {Phoenix.PubSub, name: Foody.PubSub},
      # Start the Endpoint (http/https)
      FoodyWeb.Endpoint,
      {Foody.MobileFoodPermitETS, []}
      # Start a worker by calling: Foody.Worker.start_link(arg)
      # {Foody.Worker, arg}
    ]

    # See https://hexdocs.pm/elixir/Supervisor.html
    # for other strategies and supported options
    opts = [strategy: :one_for_one, name: Foody.Supervisor]
    Supervisor.start_link(children, opts)
  end

  # Tell Phoenix to update the endpoint configuration
  # whenever the application is updated.
  @impl true
  def config_change(changed, _new, removed) do
    FoodyWeb.Endpoint.config_change(changed, removed)
    :ok
  end
end
