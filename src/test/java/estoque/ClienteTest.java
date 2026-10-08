package estoque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveNotificarUmCliente() {
        Produto produto = new Produto(500, "Teclado Mecanico", "Perifericos", "Logitech");
        Cliente cliente = new Cliente("Cliente 1");
        cliente.avisarQuandoChegar(produto);
        produto.reporEstoque();
        assertEquals("Cliente 1, estoque reposto do Produto{codigo=500, nome='Teclado Mecanico', categoria='Perifericos', marca='Logitech'}", cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClientes() {
        Produto produto = new Produto(500, "Teclado Mecanico", "Perifericos", "Logitech");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.avisarQuandoChegar(produto);
        cliente2.avisarQuandoChegar(produto);
        produto.reporEstoque();
        assertEquals("Cliente 1, estoque reposto do Produto{codigo=500, nome='Teclado Mecanico', categoria='Perifericos', marca='Logitech'}", cliente1.getUltimaNotificacao());
        assertEquals("Cliente 2, estoque reposto do Produto{codigo=500, nome='Teclado Mecanico', categoria='Perifericos', marca='Logitech'}", cliente2.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarCliente() {
        Produto produto = new Produto(500, "Teclado Mecanico", "Perifericos", "Logitech");
        Cliente cliente = new Cliente("Cliente 1");
        produto.reporEstoque();
        assertEquals(null, cliente.getUltimaNotificacao());
    }

    @Test
    void deveNotificarClienteTeclado() {
        Produto teclado = new Produto(500, "Teclado Mecanico", "Perifericos", "Logitech");
        Produto monitor = new Produto(600, "Monitor 27", "Monitores", "Dell");
        Cliente cliente1 = new Cliente("Cliente 1");
        Cliente cliente2 = new Cliente("Cliente 2");
        cliente1.avisarQuandoChegar(teclado);
        cliente2.avisarQuandoChegar(monitor);
        teclado.reporEstoque();
        assertEquals("Cliente 1, estoque reposto do Produto{codigo=500, nome='Teclado Mecanico', categoria='Perifericos', marca='Logitech'}", cliente1.getUltimaNotificacao());
        assertEquals(null, cliente2.getUltimaNotificacao());
    }
}