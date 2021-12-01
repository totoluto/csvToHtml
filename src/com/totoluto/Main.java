/**
 * @project: csvToHtml
 * @author: totoluto
 * @date: 28.11.2021
 * @version: 1.0.1
 */

package com.totoluto;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {

    public static void main(String[] args) throws IOException {

        FileReader csvReader = new FileReader("data.csv", StandardCharsets.UTF_8); // data.csv is produced by https://generatedata.com
        BufferedReader bReader = new BufferedReader(csvReader);
        String row;
        int counter = 0;

        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt", StandardCharsets.UTF_8, false));
        writer.write("<table>\n");
        while ((row = bReader.readLine()) != null) {
            String[] data = row.split(",");

            if(counter == 0){
                writer.write("\t <tr>\n" +
                        "\t \t <th>"+ data[0] + "</th>\n" + // first data column
                        "\t \t <th>"+ data[1] +"</th>\n" + // second data column
                        "\t \t <th>"+ data[2] +"</th>\n" + // third data column
                        "\t \t <th>"+ data[3] +"</th>\n" + // fourth data column
                        // Add more <th> and count data[n] up
                        "\t </tr>\n");
            }else{
                writer.write("\t <tr>\n" +
                        "\t \t <td>"+ data[0] + "</td>\n" + // first data column
                        "\t \t <td>"+ data[1] +"</td>\n" + // second data column
                        "\t \t <td>"+ data[2] +"</td>\n" + // third data column
                        "\t \t <td>"+ data[3] +"</td>\n" + // fourth data column
                        //Add more <td> and count data[n] up (adjust it to how many rows you have)
                        "\t </tr>\n");
            }
            counter++;
        }
        writer.write("</table>");
        csvReader.close();
        writer.close();
    }
}
