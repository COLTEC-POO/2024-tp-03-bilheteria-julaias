import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

abstract class Evento implements IReceita{
    private String nome;
    private Date data;
    private double hora;
    private String local;
    protected int capacidade;
    private double preco;
    public SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy"); // Para converter String para Date
    protected ArrayList<Ingresso> ingressos;

    public Evento (String nome, String data, double hora, String local, double preco) {
        this.nome = nome;
        try{ // Converte String para Date
            this.data = formatoData.parse(data);
        }catch (Exception e){
            System.out.println("<< Date Error >>");
        }
        this.hora = hora;
        this.local = local;
        this.preco = preco;
        this.ingressos = new ArrayList<>();
    }

    public abstract void addIngresso(Ingresso newIngresso);

    public double totalVendas() {
        double total = 0;

        for (Ingresso atual : this.ingressos) {
            if(atual != null) {
                total += atual.valor;
            }
        }
        return total;
    }

    public int lugaresDisp() {
        return capacidade - ingressos.size();
    }

    public int ingressoNormalDisp() {
        int i = 0;
        for (Ingresso atual : this.ingressos) {
            if(atual != null && atual.tipo == 'n') {
                i++;
            }
        }
        return i;
    }

    public int ingressoMeiaDisp() {
        int i = 0;
        for (Ingresso atual : this.ingressos) {
            if(atual != null && atual.tipo == 'm') {
                i++;
            }
        }
        return i;
    }

    public int ingressoVIPDisp() {
        int i = 0;
        for (Ingresso atual : this.ingressos) {
            if(atual != null && atual.tipo == 'v') {
                i++;
            }
        }
        return i;
    }

    public double getPreco () {
        return this.preco;
    }

    public String getNome() {
        return this.nome;
    }
}
