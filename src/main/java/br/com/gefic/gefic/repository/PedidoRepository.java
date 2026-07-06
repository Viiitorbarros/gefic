package br.com.gefic.gefic.repository;

import br.com.gefic.gefic.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long > {

    List<Pedido> findByDataDoVencimentoBefore(Date dataDoVencimentoBefore);

}
