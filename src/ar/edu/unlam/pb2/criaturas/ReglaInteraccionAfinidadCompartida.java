package ar.edu.unlam.pb2.criaturas;

public class ReglaInteraccionAfinidadCompartida implements ReglaInteraccion {

    @Override
    public boolean aplicar(Criatura a, Criatura b) {
        if (a.getAfinidadPrincipal() == b.getAfinidadPrincipal()) {
            a.setEnergia(a.getEnergia() + 10);
            b.setEnergia(b.getEnergia() + 10);
            return true;
        }
        return false;
    }
}
