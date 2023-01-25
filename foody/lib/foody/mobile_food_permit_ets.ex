defmodule Foody.MobileFoodPermitETS do
  use GenServer

  alias Foody.CsvParsers

  @table :mobile_permits

  def csv_file_path(), do: "#{:code.priv_dir(:foody)}/mobile_food_permit.csv"

  @doc """
  Starts the registry.
  """
  def start_link(opts), do: GenServer.start_link(__MODULE__, :ok, opts)

  @impl true
  def init(:ok) do
    :ets.new(@table, [:set, :public, :named_table])

    insert_permits_into_table()

    {:ok, %{}}
  end

  def list() do
    :ets.foldl(
      fn permit, acc ->
        permit_map = %{
          name: elem(permit, 0),
          type: elem(permit, 1),
          address_description: elem(permit, 2),
          address: elem(permit, 3),
          permit_status: elem(permit, 4),
          food_description: elem(permit, 5),
          longitude: elem(permit, 6),
          latitude: elem(permit, 7),
          hours: elem(permit, 8)
        }

        [permit_map | acc]
      end,
      [],
      @table
    )
  end

  defp insert_permits_into_table(), do: :ets.insert(@table, get_permits())

  defp get_permits() do
    permits = CsvParsers.csv_to_list(csv_file_path())

    for [
          _locationid,
          applicant,
          facility_type,
          _cnn,
          location_description,
          address,
          _blocklot,
          _block,
          _lot,
          _permit,
          status,
          food_items,
          _xCoord,
          _yCoord,
          latitude,
          longitude,
          _schedule,
          days_hours,
          _noi_sent,
          approved,
          _received,
          _prior_permit,
          _xxpiration_date,
          _location,
          _fire_prevention_districts,
          _police_districts,
          _supervisor_districts,
          _zip_codes,
          _neighborhoods
        ] <- permits do
      {applicant, facility_type, location_description, address, status, food_items, latitude,
       longitude, days_hours}
    end
  end
end
