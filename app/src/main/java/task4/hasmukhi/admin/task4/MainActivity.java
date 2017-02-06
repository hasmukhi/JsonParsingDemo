package task4.hasmukhi.admin.task4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.*;

public class MainActivity extends AppCompatActivity {

    public String JSON_STRING  = "{" +
            "    \"glossary\": {\n" +
            "        \"title\": \"example glossary\",\n" +
            "\t\t\"GlossDiv\": {\n" +
            "            \"title\": \"S\",\n" +
            "\t\t\t\"GlossList\": {\n" +
            "                \"GlossEntry\": {\n" +
            "                    \"ID\": \"SGML\",\n" +
            "\t\t\t\t\t\"SortAs\": \"SGML\",\n" +
            "\t\t\t\t\t\"GlossTerm\": \"Standard Generalized Markup Language\",\n" +
            "\t\t\t\t\t\"Acronym\": \"SGML\",\n" +
            "\t\t\t\t\t\"Abbrev\": \"ISO 8879:1986\",\n" +
            "\t\t\t\t\t\"GlossDef\": {\n" +
            "                        \"para\": \"A meta-markup language, used to create markup languages such as DocBook.\",\n" +
            "\t\t\t\t\t\t\"GlossSeeAlso\": [\"GML\", \"XML\"]\n" +
            "                    },\n" +
            "\t\t\t\t\t\"GlossSee\": \"markup\"\n" +
            "                }\n" +
            "            }\n" +
            "        }\n" +
            "    }\n" +
            "}";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadjson();
    }
    public void loadjson(){
        try {
            JSONObject loadjson = (new JSONObject(JSON_STRING));
            JSONObject glossaryobject=loadjson.getJSONObject("glossary");
            String title=loadjson.getString("title");
            Log.d("tag","Title of root"+title);

            JSONObject glossdivobject=loadjson.getJSONObject("GlossDiv");
            String title1=glossdivobject.getString("title");
            Log.d("tag","Title og glossdiv"+title1);

            JSONObject glossListobject=glossdivobject.getJSONObject("GlossList");
            JSONObject glossEntryobject=glossListobject.getJSONObject("GlossEntry");
            String id1=glossEntryobject.getString("ID");
            Log.d("tag", "id "+id1);
            String SortAS1=glossEntryobject.getString("SortAs");
            Log.d("tag","sortAs"+SortAS1);
            String GlossTerm1=glossEntryobject.getString("GlossTerm");
            Log.d("tag", "glossterm"+GlossTerm1);
            String Acronym1=glossEntryobject.getString("Acronym");
            Log.d("tag", "acronym"+Acronym1);
            String Abbrev1=glossEntryobject.getString("Abbrev");
            Log.d("tag", "abbrev"+Abbrev1);

            JSONObject glossDefObject=glossEntryobject.getJSONObject("GlossDef");
            String para=glossDefObject.getString("para");
            Log.d("tag", "para"+para);

            JSONArray glossSeeAlso=glossDefObject.getJSONArray("GlossSeeAlso");
            for (int i = 0; i <glossSeeAlso.length() ; i++) {
                String temp1 = glossSeeAlso.getString(i);
                Log.d("tag", "glossSeeAlso"+temp1);

            }

            String glossSee=glossEntryobject.getString("GlossSee");
            Log.d("tag", "glossSee"+glossSee);

          //  glossaryobject.get("glossary");



        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


}
