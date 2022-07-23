package ua.levelup;

public class MainTransformer {
    static char[] from = {'a', 'b', 't', 'r', 'z'};
    static char[] to = {'c', 'd', 'q', 'v', 'x'};
    static int iter = from.length;

    public static void main(String[] args) {
        try(TransformerInputStream transf = doTransform(iter))
        {
            int read;
            while ((read = transf.read()) != -1){
                System.out.print((char) read);
            }
        }
        catch (Exception error){
            System.err.println(error.getMessage());
        }
    }

    static TransformerInputStream doTransform(int k){
        return new TransformerInputStream(k==1 ? System.in : doTransform(k - 1), from[k - 1], to[k - 1]);
    }
}
