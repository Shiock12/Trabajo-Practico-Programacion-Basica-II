package ar.edu.unlam.pb2.criaturas;

public class ReglaInteraccionAfinidadOpuesta implements ReglaInteraccion {

    @Override
    public boolean aplicar(Criatura a, Criatura b) {
        AfinidadElemental afA = a.getAfinidadPrincipal();
        AfinidadElemental afB = b.getAfinidadPrincipal();

        if (sonOpuestas(afA, afB)) {
            a.setEstadoEmocional(EstadoEmocional.INESTABLE);
            b.setEstadoEmocional(EstadoEmocional.INESTABLE);
            return true;
        }

        return false;
    }

    private boolean sonOpuestas(AfinidadElemental a, AfinidadElemental b) {
        return (a == AfinidadElemental.AGUA && b == AfinidadElemental.FUEGO) ||
               (a == AfinidadElemental.FUEGO && b == AfinidadElemental.AGUA) ||
               (a == AfinidadElemental.AIRE && b == AfinidadElemental.TIERRA) ||
               (a == AfinidadElemental.TIERRA && b == AfinidadElemental.AIRE);
    }
}
