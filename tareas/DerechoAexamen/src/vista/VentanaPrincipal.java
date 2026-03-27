package vista;

import controlador.*;
import modelo.Inventario;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    public JDesktopPane desktop;

    private JMenuItem menuProductos;
    private JMenuItem menuInventario;
    private JMenuItem menuProveedores;
    private JMenuItem menuPuntoVenta;
    private JMenuItem menuReportes;
    private JMenuItem menuUnidades;

    private Inventario inventario;

    public VentanaPrincipal(Inventario inventario) {

        this.inventario = inventario;

        setTitle("Sistema de Tienda de Abarrotes");
        setSize(1100, 680);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        desktop = new JDesktopPane();
        desktop.setBackground(new Color(240, 240, 240));

        setLayout(new BorderLayout());
        add(desktop, BorderLayout.CENTER);

        crearMenu();
        crearBanner();
    }

    private void crearMenu() {

        JMenuBar barra = new JMenuBar();

        // ── MÓDULOS ───────────────────────────────────────────────
        JMenu modulos = new JMenu("Módulos");

        menuProductos   = new JMenuItem("🛒  Productos");
        menuInventario  = new JMenuItem("📦  Inventario");
        menuProveedores = new JMenuItem("🚚  Proveedores");
        menuPuntoVenta  = new JMenuItem("💰  Punto de Venta");
        menuReportes    = new JMenuItem("📊  Reportes");

        modulos.add(menuProductos);
        modulos.add(menuInventario);
        modulos.add(menuProveedores);
        modulos.addSeparator();
        modulos.add(menuPuntoVenta);
        modulos.addSeparator();
        modulos.add(menuReportes);

        // ── CONFIGURACIÓN ─────────────────────────────────────────
        JMenu configuracion = new JMenu("Configuración");

        menuUnidades = new JMenuItem("📏  Unidades de Medida");
        configuracion.add(menuUnidades);

        barra.add(modulos);
        barra.add(configuracion);
        setJMenuBar(barra);

        // ── EVENTOS ───────────────────────────────────────────────
        menuProductos.addActionListener(e   -> abrirProductos());
        menuInventario.addActionListener(e  -> abrirInventario());
        menuProveedores.addActionListener(e -> abrirProveedores());
        menuPuntoVenta.addActionListener(e  -> abrirPuntoVenta());
        menuReportes.addActionListener(e    -> abrirReportes());
        menuUnidades.addActionListener(e    -> abrirUnidades());
    }

    private void crearBanner() {

        JPanel banner = new JPanel(new BorderLayout());
        banner.setBackground(new Color(34, 139, 34));
        banner.setPreferredSize(new Dimension(0, 60));

        JLabel titulo = new JLabel("🏪  Tienda de Abarrotes", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 24));
        titulo.setForeground(Color.WHITE);

        JLabel subtitulo = new JLabel("Sistema de Punto de Venta", JLabel.CENTER);
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 12));
        subtitulo.setForeground(new Color(200, 255, 200));

        JPanel textos = new JPanel(new GridLayout(2, 1));
        textos.setOpaque(false);
        textos.add(titulo);
        textos.add(subtitulo);

        banner.add(textos, BorderLayout.CENTER);
        add(banner, BorderLayout.NORTH);
    }

    // ── ABRIR MÓDULOS ─────────────────────────────────────────────

    private void abrirProductos() {
        VistaProductos v = new VistaProductos();
        desktop.add(v);
        v.setVisible(true);
        new ControladorProductos(v, inventario);
    }

    private void abrirInventario() {
        VistaInventario v = new VistaInventario();
        desktop.add(v);
        v.setVisible(true);
        new ControladorInventario(v, inventario);
    }

    private void abrirProveedores() {
        VistaProveedores v = new VistaProveedores();
        desktop.add(v);
        v.setVisible(true);
        new ControladorProveedores(v, inventario);
    }

    private void abrirPuntoVenta() {
        VistaPuntoVenta v = new VistaPuntoVenta();
        desktop.add(v);
        v.setVisible(true);
        new ControladorPuntoVenta(v, inventario);
    }

    private void abrirReportes() {
        VistaReportes v = new VistaReportes();
        desktop.add(v);
        v.setVisible(true);
        new ControladorReportes(v, inventario);
    }

    private void abrirUnidades() {
        VistaUnidades v = new VistaUnidades();
        desktop.add(v);
        v.setVisible(true);
        new ControladorUnidades(v, inventario);
    }
}