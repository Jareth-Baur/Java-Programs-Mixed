import java.util.*;

class DataProcessor {
    // ! tig gunit sa numbers
    private ArrayList<String> dataList = new ArrayList<>();

    // ! tig gunit sa numbers, pero sa table ni
    private String[][] dataTable = new String[18][9];

    // ! tig gunit sa next address, sa table
    private String[][] nextAddress = new String[18][9];

    // ! tig gunit sa previous address, sa table
    private String[][] previousAddress = new String[18][9];

    // ! Constructor
    public DataProcessor() {
        int[][] unavailableIndices = {
                { 0, 1 }, { 1, 3 }, { 1, 6 }, { 3, 0 }, { 4, 4 },
                { 6, 2 }, { 7, 5 }, { 8, 0 }, { 10, 2 }, { 10, 3 },
                { 10, 5 }, { 11, 8 }, { 13, 1 }, { 14, 4 }, { 15, 6 },
                { 16, 2 }, { 16, 8 }
        };// ! Set specific cells in the data table as "Unavailable"
        String unavailableValue = "Unavailable";
        for (int[] indices : unavailableIndices) {
            dataTable[indices[0]][indices[1]] = unavailableValue;
        }
    }

    // ! Mo return sya sa list of numbers sa mga gi add nimo
    public ArrayList<String> getDataList() {
        return dataList;
    }

    public void addData(String data) {
        int index;
        boolean withIndex = false;
        if (data.contains(",")) {
            String[] splittedData = data.split(",");
            index = Integer.parseInt(splittedData[0]);
            withIndex = true;
            data = splittedData[1];
            dataList.add(index, data);
            System.out.print(data);
        } else {
            index = dataList.size();
            dataList.add(data);
            System.out.print(data);
        }
        if (index < 0 || index > dataList.size()) {
            System.out.println("Index out of bounds!");
            return;
        }

        for (int i = 0; i < dataTable.length; i++) {
            for (int j = 0; j < dataTable[i].length; j++) {
                if (dataTable[i][j] == null) {
                    dataTable[i][j] = data;
                    nextAddress[i][j] = "| null";
                    previousAddress[i][j] = "null |";
                    if (dataList.size() > 1) {
                        String prevData;
                        String nextData;
                        if (index > 0) {
                            prevData = dataList.get(index - 1);
                        } else {
                            prevData = dataList.get(index);
                        }
                        if (index < dataList.size() - 1) {
                            nextData = dataList.get(index + 1);
                        } else {
                            nextData = dataList.get(index);
                        }
                        for (int z = 0; z < dataTable.length; z++) {
                            for (int x = 0; x < dataTable[z].length; x++) {
                                if (dataTable[z][x] != null && dataTable[z][x].equals(prevData)) {
                                    nextAddress[z][x] = "| " + i + "," + j;
                                    previousAddress[i][j] = z + "," + x + " |";
                                }
                                if (index == 0 && withIndex) {
                                    if (dataTable[z][x] != null && dataTable[z][x].equals(nextData)) {
                                        previousAddress[z][x] = i + "," + j + " |";
                                        nextAddress[i][j] = "| " + z + "," + x;
                                        return;
                                    }
                                } else if (index == dataList.size() - 1 && withIndex) {
                                    if (dataTable[z][x] != null && dataTable[z][x].equals(prevData)) {
                                        previousAddress[i][j] = z + "," + x + " |";
                                        nextAddress[z][x] = "| " + i + "," + j;
                                        return;
                                    }
                                } else if (index > 0 && index < dataList.size() - 1 && withIndex) {
                                    if (dataTable[z][x] != null && dataTable[z][x].equals(nextData)) {
                                        previousAddress[z][x] = i + "," + j + " |";
                                        nextAddress[i][j] = "| " + z + "," + x;
                                        return;
                                    }
                                }
                                if (dataTable[z][x] == null) {
                                    return;
                                }
                            }
                        }
                    }
                    return;
                }
            }
        }
    }

    // ! Print the data table
    public void printDataTable() {
        String format = "| %-2s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s | %-15s |\n";
        String line = "------------------------------------------------------------------------------------";

        System.out.println(line + line);
        System.out.print(String.format(format, "", "    0", "    1", "    2", "    3", "    4", "    5", "    6",
                "    7", "    8"));
        System.out.println(line + line);

        for (int a = 0; a < dataTable.length; a++) {
            System.out.print(String.format("| %-2s ", a));
            for (int b = 0; b < dataTable[a].length; b++) {
                if (previousAddress[a][b] == null && dataTable[a][b] == null && nextAddress[a][b] == null) {
                    System.out.printf("| %-15s ", "");
                } else {
                    if (nextAddress[a][b] != null && previousAddress[a][b] != null) {
                        System.out.printf("| %-15s ", previousAddress[a][b] + dataTable[a][b] + nextAddress[a][b]);
                    } else {
                        System.out.printf("| %-15s ", "" + dataTable[a][b] + "");
                    }
                }
                // String data = dataTable[a][b] == null ? "" : dataTable[a][b] +
                // (dataTableAddress[a][b] == null ? "" : dataTableAddress[a][b]);
                // System.out.printf("| %-15s ", data);
            }
            System.out.println("|");
            System.out.println(line + line);
        }
    }
}