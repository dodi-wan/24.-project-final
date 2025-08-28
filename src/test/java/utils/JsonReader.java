package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class JsonReader {

    public static void main(String[] args) {

        try {

            String content = new String(Files.readAllBytes(
                    Paths.get("target/api-report.json")));

            content = content.trim();

            // Loop isi array
            if(content.trim().startsWith("{")) {
                JSONObject jsonObject = new JSONObject(content);
                System.out.println("data adalah object" + jsonObject.toString(4));
            } else if (content.trim().startsWith("[")) {
                JSONObject jsonObject = new JSONObject(content);
                System.out.println("data adalah array : " + jsonObject.toString(4));
            } else{
                System.out.println("tidak diketahui jenis datanya " + content);
                System.out.println(content.substring(0, 200));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
