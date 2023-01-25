defmodule Foody.Repo do
  use Ecto.Repo,
    otp_app: :foody,
    adapter: Ecto.Adapters.Postgres
end
