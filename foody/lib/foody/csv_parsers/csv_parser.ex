defmodule Foody.CsvParsers do
  @moduledoc """
  functions for parsing csv files.
  """

  # Parses a CSV file and returns a list of rows.
  # Ex: [[header1, header2], [a2, b2], [a3, b3]]
  def csv_to_list(path) do
    path
    |> File.stream!()
    |> CSV.decode!()
    |> Enum.to_list()
  end
end
