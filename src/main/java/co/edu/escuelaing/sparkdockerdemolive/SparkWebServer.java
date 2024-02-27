package co.edu.escuelaing.sparkdockerdemolive;


import static spark.Spark.get;
import static spark.Spark.port;

public class SparkWebServer {
    
    public static void main(String... args){
        port(getPort());
        get("hello", (req,res) -> "Hello Docker!");
        get("index", (req, res) -> "operaciones = sen,cos,mag,pal Para utilizar cada operación ingresela en la url, ejemplo = ( localhost:4567/sen?value=10)");
        get("/sen", (req, res) -> Math.sin(Double.parseDouble(req.queryParams("value"))));
        get("/mag", (req, res) -> {
        	int x = Integer.parseInt(req.queryParams("x"));
        	int y = Integer.parseInt(req.queryParams("y"));
        	double xcua = x*x;
        	double ycua = y*y;
        	double sum = xcua+ycua;
        	return "La magnitud del vector donde X  es = "+Integer.toString(x)+" y Y es = "+Integer.toString(y)+ " es igual a : " +Double.toString(Math.sqrt(sum));
        });
        get("/cos", (req, res) -> Math.cos(Double.parseDouble(req.queryParams("value"))));
        get("/pal", (req, res) -> {
        	String str = req.queryParams("value");
        	String pali = "";
        	int valueLenght = str.length();
        	for (int i = 0; i < valueLenght; i++) {
        		pali+= str.charAt(valueLenght-1-i);
        	}
        	if (pali.toLowerCase().equals(str.toLowerCase())) {
        		return "Es Palindromo";
        	}else {
        		return "No es palindromo";
        	}
        });

    }
	private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
  
}