package com.lojaauto.controller;

import com.lojaauto.dto.VeiculoDTO;
import com.lojaauto.VeiculoEletricoBase;
import com.lojaauto.carroFactory.VeiculoEletricoFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    private final AtomicInteger idCounter = new AtomicInteger(0);

    private final Map<Integer, VeiculoEletricoBase> repo = new ConcurrentHashMap<>();

    @PostMapping
    public ResponseEntity<VeiculoEletricoBase> cadastrar(@RequestBody VeiculoDTO dto) {
        VeiculoEletricoBase veiculo = (VeiculoEletricoBase)
                VeiculoEletricoFactory.escolherVeiculo(dto.getTipo());

        veiculo.setModelo(dto.getModelo());
        veiculo.setAutonomiaKm(dto.getAutonomiaKm());
        veiculo.setPreco(dto.getPreco());

        int id = idCounter.incrementAndGet();
        veiculo.setId(id);

        repo.put(id, veiculo);

        return ResponseEntity.created(URI.create("/veiculos/" + id)).body(veiculo);
    }

    @GetMapping
    public List<VeiculoEletricoBase> listar() {
        return new ArrayList<>(repo.values());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoEletricoBase> buscar(@PathVariable Integer id) {
        VeiculoEletricoBase v = repo.get(id);
        if (v == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(v);
    }

    @PostMapping("/{id}/carregar")
    public ResponseEntity<String> carregar(@PathVariable Integer id) {
        VeiculoEletricoBase veiculo = repo.get(id);
        if (veiculo == null) return ResponseEntity.notFound().build();

        veiculo.carregar(); // método imprime no console, mas devolvemos mensagem
        String msg = veiculo.getModelo() + " está carregando!";
        return ResponseEntity.ok(msg);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (repo.remove(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/tipo/{tipo}")
    public List<VeiculoEletricoBase> porTipo(@PathVariable String tipo) {
        List<VeiculoEletricoBase> result = new ArrayList<>();
        for (VeiculoEletricoBase v : repo.values()) {
            if (v.getClass().getSimpleName().toLowerCase().contains(tipo.toLowerCase())) {
                result.add(v);
            }
        }
        return result;
    }
}
