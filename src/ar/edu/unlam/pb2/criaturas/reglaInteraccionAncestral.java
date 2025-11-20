package ar.edu.unlam.pb2.criaturas;

public class reglaInteraccionAncestral implements ReglaInteraccion {

    @Override
    public boolean aplicar(Criatura a, Criatura b) {
        boolean aEsAncestral = a instanceof CriaturaAncestral;
        boolean bEsAncestral = b instanceof CriaturaAncestral;

        // "Si una es ancestral" -> exactamente una de las dos
        if (aEsAncestral ^ bEsAncestral) {
            Criatura ancestral = aEsAncestral ? a : b;
            Criatura otra = aEsAncestral ? b : a;

            // La ancestral gana 20 energía
            ancestral.setEnergia(ancestral.getEnergia() + 20);

            // La otra pierde 15, mínimo 0
            Integer energiaOtra = otra.getEnergia() - 15;
            if (energiaOtra < 0) {
                energiaOtra = 0;
            }
            otra.setEnergia(energiaOtra);

            return true;
        }

        return false;
    }
}

