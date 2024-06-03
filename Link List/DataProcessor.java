import java.util.*;

class DataProcessor {
    // ! tig gunit sa numbers
    private ArrayList<String> dataList = new ArrayList<>();

    // ! tig gunit sa numbers, pero sa table ni
    private String[][] dataTable = new String[18][9];

    // ! tig gunit sa next address, sa table
    private String[][] dataTableAddress = new String[18][9];

    // ! Constructor na 
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

    // ! mo add sa table ug value lang
    public void addData(String input) {
        
        int dataIndex = dataList.size();

        dataList.add(input);

        // ! Para mangita ug bakante nga index sa table
        for (int i = 0; i < dataTable.length; i++) {
            for (int j = 0; j < dataTable[i].length; j++) {
                if (dataTable[i][j] == null) {
                    dataTable[i][j] = input;
                    dataTableAddress[i][j] = " | null";
                    if (dataIndex > 0) {
                        String prevData = dataList.get(dataIndex - 1);
                        // ! nested loop napud para mangita sa value ni prevData sa dataTable
                        for (int z = 0; z < dataTable.length; z++) {
                            for (int x = 0; x < dataTable[z].length; x++) {
                                if (dataTable[z][x] != null && dataTable[z][x].equals(prevData)) {
                                    dataTableAddress[z][x] = " | " + i + "," + j;
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

    public void addDataWithIndex(String value) {
        String[] data = value.split(",");
        int index = Integer.parseInt(data[0]);

        // ! Mo determine kung out of bounds ba ang index nga ge input sa user
        if (index < 0 || index > dataList.size()) {
            System.out.println("Index out of bounds!");
            return;
        }

        dataList.add(index, data[1]);

        // ! para mangita napud ug null or bakante sa table
        for (int a = 0; a < dataTable.length; a++) {
            for (int b = 0; b < dataTable[a].length; b++) {

                if (dataTable[a][b] == null) {
                    dataTable[a][b] = data[1];
                    dataTableAddress[a][b] = " | null";

                    // ! Mag add sa first index, sa index 0
                    if (index == 0) {
                        if (dataList.size() > 1) {
                            for (int e = 0; e < dataTable.length; e++) {
                                for (int f = 0; f < dataTable[e].length; f++) {
                                    if (dataList.get(index + 1).equals(dataTable[e][f])) {
                                        dataTableAddress[a][b] = " | " + e + "," + f;
                                        return;
                                    }
                                }
                            }
                        }
                        return;
                        // ! Mag add sa last index
                    } else if (index == (dataList.size() - 1)) {
                        for (int e = 0; e < dataTable.length; e++) {
                            for (int f = 0; f < dataTable[e].length; f++) {
                                if (dataList.get(index - 1).matches("(.*)" + dataTable[e][f] + "(.*)")) {
                                    dataTableAddress[e][f] = " | " + a + "," + b;
                                    return;
                                }
                            }
                        }
                        // ! Mag add sa in between sa data list
                    } else {
                        efLoop: for (int e = 0; e < dataTable.length; e++) {
                            for (int f = 0; f < dataTable[e].length; f++) {
                                if (dataList.get(index - 1).equals(dataTable[e][f])) {
                                    dataTableAddress[e][f] = " | " + a + "," + b;
                                    break efLoop;
                                }
                            }
                        }
                        for (int g = 0; g < dataTable.length; g++) {
                            for (int h = 0; h < dataTable[g].length; h++) {
                                if (dataList.get(index + 1).equals(dataTable[g][h])) {
                                    dataTableAddress[a][b] = " | " + g + "," + h;
                                    return;
                                }
                            }
                        }
                    }
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
                if (dataTable[a][b] == null && dataTableAddress[a][b] == null) {
                    System.out.printf("| %-15s ", "");
                } else {
                    if (dataTableAddress[a][b] != null) {
                        System.out.printf("| %-15s ", dataTable[a][b] + dataTableAddress[a][b]);
                    } else {
                        System.out.printf("| %-15s ", dataTable[a][b] + "");
                    }
                }
            }
            System.out.println("|");
            System.out.println(line + line);
        }
    }
}