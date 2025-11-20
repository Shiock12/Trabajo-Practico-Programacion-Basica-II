package ar.edu.unlam.pb2.criaturas;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReporteConsejo {

    // 1. Listar todas las criaturas
    public List<Criatura> listarTodasLasCriaturas(List<MaestroElemental> maestros) {
        return maestros.stream()
                .flatMap(m -> m.getCriaturas().stream())
                .toList();
    }

    // 2. Criatura con más energía
    public Criatura buscarCriaturaConMasEnergia(List<MaestroElemental> maestros) {
        return listarTodasLasCriaturas(maestros).stream()
                .max((c1, c2) -> c1.getEnergia().compareTo(c2.getEnergia()))
                .orElse(null);
    }

    // 3. Maestro con más criaturas transformadas
    public MaestroElemental maestroConMasCriaturasTransformadas(List<MaestroElemental> maestros) {
        return maestros.stream()
                .max((m1, m2) ->
                        Long.compare(
                                m1.getCriaturas().stream().filter(Criatura::estaTransformada).count(),
                                m2.getCriaturas().stream().filter(Criatura::estaTransformada).count()
                        )
                )
                .orElse(null);
    }

    // 4. Cantidad por afinidad elemental
    public Map<AfinidadElemental, Integer> cantidadPorAfinidad(List<MaestroElemental> maestros) {
        return listarTodasLasCriaturas(maestros).stream()
                .collect(Collectors.groupingBy(
                        Criatura::getAfinidadPrincipal,
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
                ));
    }
}
