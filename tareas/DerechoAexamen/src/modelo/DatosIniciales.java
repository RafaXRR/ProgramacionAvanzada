package modelo;

public class DatosIniciales {

    public static void cargarProductos(Inventario inventario) {

        // ── DESPENSA BÁSICA (DES) ─────────────────────────────────
        inventario.agregar(new ProductoDespensa(1,  "DES001", "Arroz 1kg",          18.0, 30, 50, "imagenes/despensa_basica/DES001.png", "KG"));
        inventario.agregar(new ProductoDespensa(2,  "DES002", "Frijol Negro 1kg",   20.0, 30, 40, "imagenes/despensa_basica/DES002.png", "KG"));
        inventario.agregar(new ProductoDespensa(3,  "DES003", "Aceite 1L",          28.0, 25, 35, "imagenes/despensa_basica/DES003.png", "LT"));
        inventario.agregar(new ProductoDespensa(4,  "DES004", "Pasta Spaghetti",     8.0, 40, 60, "imagenes/despensa_basica/DES004.png", "PZA"));
        inventario.agregar(new ProductoDespensa(5,  "DES005", "Harina de Trigo 1kg",16.0, 30, 45, "imagenes/despensa_basica/DES005.png", "KG"));
        inventario.agregar(new ProductoDespensa(6,  "DES006", "Azúcar 1kg",         18.0, 25, 55, "imagenes/despensa_basica/DES006.png", "KG"));
        inventario.agregar(new ProductoDespensa(7,  "DES007", "Sal 1kg",             5.0, 50, 70, "imagenes/despensa_basica/DES007.png", "KG"));
        inventario.agregar(new ProductoDespensa(8,  "DES008", "Lenteja 500g",       12.0, 35, 30, "imagenes/despensa_basica/DES008.png", "BOL"));
        inventario.agregar(new ProductoDespensa(9,  "DES009", "Avena 500g",         14.0, 30, 40, "imagenes/despensa_basica/DES009.png", "BOL"));
        inventario.agregar(new ProductoDespensa(10, "DES010", "Maíz Cacahuazintle", 22.0, 25, 25, "imagenes/despensa_basica/DES010.png", "KG"));

        // ── LÁCTEOS Y HUEVO (LAC) ─────────────────────────────────
        inventario.agregar(new ProductoLacteo(11, "LAC001", "Leche Entera 1L",       18.0, 20, 40, "imagenes/lacteos_huevo/LAC001.png", "LT"));
        inventario.agregar(new ProductoLacteo(12, "LAC002", "Leche Deslactosada 1L", 20.0, 20, 35, "imagenes/lacteos_huevo/LAC002.png", "LT"));
        inventario.agregar(new ProductoLacteo(13, "LAC003", "Huevo 12 piezas",       35.0, 20, 50, "imagenes/lacteos_huevo/LAC003.png", "DOC"));
        inventario.agregar(new ProductoLacteo(14, "LAC004", "Queso Fresco 400g",     45.0, 25, 25, "imagenes/lacteos_huevo/LAC004.png", "PZA"));
        inventario.agregar(new ProductoLacteo(15, "LAC005", "Yogur Natural 1kg",     28.0, 30, 30, "imagenes/lacteos_huevo/LAC005.png", "KG"));
        inventario.agregar(new ProductoLacteo(16, "LAC006", "Mantequilla 90g",       22.0, 35, 35, "imagenes/lacteos_huevo/LAC006.png", "PZA"));
        inventario.agregar(new ProductoLacteo(17, "LAC007", "Crema 200ml",           18.0, 30, 40, "imagenes/lacteos_huevo/LAC007.png", "ML"));
        inventario.agregar(new ProductoLacteo(18, "LAC008", "Queso Manchego 400g",   55.0, 25, 20, "imagenes/lacteos_huevo/LAC008.png", "PZA"));
        inventario.agregar(new ProductoLacteo(19, "LAC009", "Leche Vegetal 1L",      30.0, 30, 20, "imagenes/lacteos_huevo/LAC009.png", "LT"));
        inventario.agregar(new ProductoLacteo(20, "LAC010", "Yogur Griego 150g",     16.0, 40, 30, "imagenes/lacteos_huevo/LAC010.png", "PZA"));

        // ── BEBIDAS Y LÍQUIDOS (BEB) ──────────────────────────────
        inventario.agregar(new ProductoBebida(21, "BEB001", "Agua Natural 1L",       5.0, 60, 100, "imagenes/bebidas/BEB001.png", "LT"));
        inventario.agregar(new ProductoBebida(22, "BEB002", "Refresco Cola 600ml",  10.0, 70,  80, "imagenes/bebidas/BEB002.png", "ML"));
        inventario.agregar(new ProductoBebida(23, "BEB003", "Jugo Naranja 1L",      18.0, 40,  50, "imagenes/bebidas/BEB003.png", "LT"));
        inventario.agregar(new ProductoBebida(24, "BEB004", "Café Soluble 200g",    35.0, 50,  30, "imagenes/bebidas/BEB004.png", "GR"));
        inventario.agregar(new ProductoBebida(25, "BEB005", "Té Verde 25 sobres",   20.0, 40,  40, "imagenes/bebidas/BEB005.png", "PZA"));
        inventario.agregar(new ProductoBebida(26, "BEB006", "Bebida Energética",    18.0, 55,  60, "imagenes/bebidas/BEB006.png", "ML"));
        inventario.agregar(new ProductoBebida(27, "BEB007", "Agua Saborizada 600ml", 8.0, 60,  70, "imagenes/bebidas/BEB007.png", "ML"));
        inventario.agregar(new ProductoBebida(28, "BEB008", "Néctar Mango 1L",      15.0, 40,  45, "imagenes/bebidas/BEB008.png", "LT"));
        inventario.agregar(new ProductoBebida(29, "BEB009", "Chocolate en Polvo",   32.0, 35,  25, "imagenes/bebidas/BEB009.png", "GR"));
        inventario.agregar(new ProductoBebida(30, "BEB010", "Refresco Naranja 2L",  18.0, 50,  55, "imagenes/bebidas/BEB010.png", "LT"));

        // ── BOTANAS Y DULCES (BOT) ────────────────────────────────
        inventario.agregar(new ProductoBotana(31, "BOT001", "Papas Fritas 45g",     10.0, 60,  80, "imagenes/botanas_dulces/BOT001.png", "PZA"));
        inventario.agregar(new ProductoBotana(32, "BOT002", "Galletas María 200g",  12.0, 45,  70, "imagenes/botanas_dulces/BOT002.png", "PZA"));
        inventario.agregar(new ProductoBotana(33, "BOT003", "Chocolate 35g",        10.0, 60,  90, "imagenes/botanas_dulces/BOT003.png", "PZA"));
        inventario.agregar(new ProductoBotana(34, "BOT004", "Cacahuates 150g",      15.0, 40,  60, "imagenes/botanas_dulces/BOT004.png", "BOL"));
        inventario.agregar(new ProductoBotana(35, "BOT005", "Palomitas Microondas", 14.0, 50,  50, "imagenes/botanas_dulces/BOT005.png", "PZA"));
        inventario.agregar(new ProductoBotana(36, "BOT006", "Gomitas 100g",          8.0, 60, 100, "imagenes/botanas_dulces/BOT006.png", "BOL"));
        inventario.agregar(new ProductoBotana(37, "BOT007", "Frituras 65g",          9.0, 55,  85, "imagenes/botanas_dulces/BOT007.png", "PZA"));
        inventario.agregar(new ProductoBotana(38, "BOT008", "Galletas Saladas 200g",14.0, 40,  65, "imagenes/botanas_dulces/BOT008.png", "PZA"));
        inventario.agregar(new ProductoBotana(39, "BOT009", "Obleas con Cajeta",     5.0, 80, 120, "imagenes/botanas_dulces/BOT009.png", "PZA"));
        inventario.agregar(new ProductoBotana(40, "BOT010", "Nuez Mixta 100g",      28.0, 35,  30, "imagenes/botanas_dulces/BOT010.png", "BOL"));

        // ── FRUTAS Y VERDURAS (FRV) ───────────────────────────────
        inventario.agregar(new ProductoFrutaVerdura(41, "FRV001", "Manzana Roja",    22.0, 30, 40, "imagenes/frutas_verduras/FRV001.png", "KG"));
        inventario.agregar(new ProductoFrutaVerdura(42, "FRV002", "Plátano Tabasco", 12.0, 40, 50, "imagenes/frutas_verduras/FRV002.png", "KG"));
        inventario.agregar(new ProductoFrutaVerdura(43, "FRV003", "Tomate Rojo",     15.0, 35, 55, "imagenes/frutas_verduras/FRV003.png", "KG"));
        inventario.agregar(new ProductoFrutaVerdura(44, "FRV004", "Zanahoria",       10.0, 40, 60, "imagenes/frutas_verduras/FRV004.png", "KG"));
        inventario.agregar(new ProductoFrutaVerdura(45, "FRV005", "Papa Blanca",     14.0, 35, 70, "imagenes/frutas_verduras/FRV005.png", "KG"));
        inventario.agregar(new ProductoFrutaVerdura(46, "FRV006", "Naranja",         12.0, 40, 60, "imagenes/frutas_verduras/FRV006.png", "KG"));
        inventario.agregar(new ProductoFrutaVerdura(47, "FRV007", "Cebolla Blanca",  10.0, 35, 50, "imagenes/frutas_verduras/FRV007.png", "KG"));
        inventario.agregar(new ProductoFrutaVerdura(48, "FRV008", "Limón",           18.0, 30, 45, "imagenes/frutas_verduras/FRV008.png", "KG"));
        inventario.agregar(new ProductoFrutaVerdura(49, "FRV009", "Aguacate",        25.0, 40, 30, "imagenes/frutas_verduras/FRV009.png", "PZA"));
        inventario.agregar(new ProductoFrutaVerdura(50, "FRV010", "Chiles Serranos", 12.0, 45, 40, "imagenes/frutas_verduras/FRV010.png", "KG"));

        // ── CARNES Y SALCHICHONERÍA (CAR) ─────────────────────────
        inventario.agregar(new ProductoCarne(51, "CAR001", "Pechuga de Pollo",    75.0, 25, 20, "imagenes/carnes_salchichoneria/CAR001.png", "KG"));
        inventario.agregar(new ProductoCarne(52, "CAR002", "Carne Molida de Res",110.0, 20, 15, "imagenes/carnes_salchichoneria/CAR002.png", "KG"));
        inventario.agregar(new ProductoCarne(53, "CAR003", "Chuleta de Cerdo",    90.0, 22, 18, "imagenes/carnes_salchichoneria/CAR003.png", "KG"));
        inventario.agregar(new ProductoCarne(54, "CAR004", "Salchicha 250g",      28.0, 35, 30, "imagenes/carnes_salchichoneria/CAR004.png", "PZA"));
        inventario.agregar(new ProductoCarne(55, "CAR005", "Jamón 200g",          32.0, 35, 25, "imagenes/carnes_salchichoneria/CAR005.png", "PZA"));
        inventario.agregar(new ProductoCarne(56, "CAR006", "Chorizo 200g",        38.0, 30, 20, "imagenes/carnes_salchichoneria/CAR006.png", "PZA"));
        inventario.agregar(new ProductoCarne(57, "CAR007", "Filete de Tilapia",   85.0, 25, 12, "imagenes/carnes_salchichoneria/CAR007.png", "KG"));
        inventario.agregar(new ProductoCarne(58, "CAR008", "Mortadela 200g",      25.0, 40, 28, "imagenes/carnes_salchichoneria/CAR008.png", "PZA"));
        inventario.agregar(new ProductoCarne(59, "CAR009", "Milanesa de Res",    120.0, 20, 10, "imagenes/carnes_salchichoneria/CAR009.png", "KG"));
        inventario.agregar(new ProductoCarne(60, "CAR010", "Tocino 200g",         42.0, 30, 22, "imagenes/carnes_salchichoneria/CAR010.png", "PZA"));

        // ── CUIDADO DEL HOGAR (HOG) ───────────────────────────────
        inventario.agregar(new ProductoHogar(61, "HOG001", "Detergente Polvo 1kg", 38.0, 30, 40, "imagenes/cuidado_hogar/HOG001.png", "KG"));
        inventario.agregar(new ProductoHogar(62, "HOG002", "Cloro 1L",             18.0, 40, 50, "imagenes/cuidado_hogar/HOG002.png", "LT"));
        inventario.agregar(new ProductoHogar(63, "HOG003", "Suavizante 1L",        28.0, 35, 35, "imagenes/cuidado_hogar/HOG003.png", "LT"));
        inventario.agregar(new ProductoHogar(64, "HOG004", "Limpiador Multiusos",  20.0, 40, 45, "imagenes/cuidado_hogar/HOG004.png", "LT"));
        inventario.agregar(new ProductoHogar(65, "HOG005", "Papel Higiénico 4pz",  32.0, 30, 30, "imagenes/cuidado_hogar/HOG005.png", "PAQ"));
        inventario.agregar(new ProductoHogar(66, "HOG006", "Servilletas 100pz",    15.0, 40, 50, "imagenes/cuidado_hogar/HOG006.png", "PAQ"));
        inventario.agregar(new ProductoHogar(67, "HOG007", "Esponja Fibra",         8.0, 60, 60, "imagenes/cuidado_hogar/HOG007.png", "PZA"));
        inventario.agregar(new ProductoHogar(68, "HOG008", "Bolsas Basura 30pz",   22.0, 35, 40, "imagenes/cuidado_hogar/HOG008.png", "PAQ"));
        inventario.agregar(new ProductoHogar(69, "HOG009", "Desengrasante 500ml",  25.0, 40, 30, "imagenes/cuidado_hogar/HOG009.png", "ML"));
        inventario.agregar(new ProductoHogar(70, "HOG010", "Insecticida 400ml",    45.0, 30, 20, "imagenes/cuidado_hogar/HOG010.png", "ML"));

        // ── HIGIENE Y CUIDADO PERSONAL (HIG) ─────────────────────
        inventario.agregar(new ProductoHigiene(71, "HIG001", "Shampoo 400ml",       42.0, 35, 30, "imagenes/higiene_personal/HIG001.png", "ML"));
        inventario.agregar(new ProductoHigiene(72, "HIG002", "Jabón de Baño 3pz",   22.0, 40, 45, "imagenes/higiene_personal/HIG002.png", "PAQ"));
        inventario.agregar(new ProductoHigiene(73, "HIG003", "Pasta Dental 75ml",   28.0, 35, 40, "imagenes/higiene_personal/HIG003.png", "ML"));
        inventario.agregar(new ProductoHigiene(74, "HIG004", "Desodorante 150ml",   38.0, 30, 35, "imagenes/higiene_personal/HIG004.png", "ML"));
        inventario.agregar(new ProductoHigiene(75, "HIG005", "Acondicionador 400ml",40.0, 35, 25, "imagenes/higiene_personal/HIG005.png", "ML"));
        inventario.agregar(new ProductoHigiene(76, "HIG006", "Crema Corporal 200ml",35.0, 40, 20, "imagenes/higiene_personal/HIG006.png", "ML"));
        inventario.agregar(new ProductoHigiene(77, "HIG007", "Cepillo Dental",      12.0, 50, 50, "imagenes/higiene_personal/HIG007.png", "PZA"));
        inventario.agregar(new ProductoHigiene(78, "HIG008", "Gel Antibacterial",   18.0, 50, 40, "imagenes/higiene_personal/HIG008.png", "ML"));
        inventario.agregar(new ProductoHigiene(79, "HIG009", "Rastrillo 2pz",       22.0, 40, 30, "imagenes/higiene_personal/HIG009.png", "PAQ"));
        inventario.agregar(new ProductoHigiene(80, "HIG010", "Toallas Sanitarias",  35.0, 35, 25, "imagenes/higiene_personal/HIG010.png", "PAQ"));

        // ── ALIMENTOS ENLATADOS (ENL) ─────────────────────────────
        inventario.agregar(new ProductoEnlatado(81, "ENL001", "Atún en Agua 140g",   18.0, 40, 60, "imagenes/alimentos_enlatados/ENL001.png", "LTA"));
        inventario.agregar(new ProductoEnlatado(82, "ENL002", "Sardinas en Tomate",  14.0, 45, 50, "imagenes/alimentos_enlatados/ENL002.png", "LTA"));
        inventario.agregar(new ProductoEnlatado(83, "ENL003", "Frijoles Negros 400g",16.0, 35, 45, "imagenes/alimentos_enlatados/ENL003.png", "LTA"));
        inventario.agregar(new ProductoEnlatado(84, "ENL004", "Chiles Chipotles",    18.0, 40, 40, "imagenes/alimentos_enlatados/ENL004.png", "LTA"));
        inventario.agregar(new ProductoEnlatado(85, "ENL005", "Salsa de Tomate 400g",14.0, 35, 55, "imagenes/alimentos_enlatados/ENL005.png", "LTA"));
        inventario.agregar(new ProductoEnlatado(86, "ENL006", "Sopa Instantánea",     8.0, 60, 80, "imagenes/alimentos_enlatados/ENL006.png", "PZA"));
        inventario.agregar(new ProductoEnlatado(87, "ENL007", "Maíz Elote 400g",     14.0, 35, 40, "imagenes/alimentos_enlatados/ENL007.png", "LTA"));
        inventario.agregar(new ProductoEnlatado(88, "ENL008", "Champiñones 400g",    20.0, 35, 30, "imagenes/alimentos_enlatados/ENL008.png", "LTA"));
        inventario.agregar(new ProductoEnlatado(89, "ENL009", "Caldo de Pollo 1L",   22.0, 30, 35, "imagenes/alimentos_enlatados/ENL009.png", "LTA"));
        inventario.agregar(new ProductoEnlatado(90, "ENL010", "Pasta de Tomate 200g",12.0, 40, 45, "imagenes/alimentos_enlatados/ENL010.png", "LTA"));
    }

    public static void cargarProveedoresEjemplo(Inventario inventario) {
        inventario.agregarProveedor(new Proveedor(1, "PROV001", "Distribuidora Norte S.A.",
                "Juan Pérez", "867-100-2000", "ventas@dnorte.com",
                "Blvd. Morelos 100, Tampico", "DNO123456ABC", "Contado"));

        inventario.agregarProveedor(new Proveedor(2, "PROV002", "Abarrotes del Golfo",
                "María López", "867-200-3000", "contacto@agolfo.com",
                "Av. Hidalgo 50, Tampico", "AGL654321XYZ", "30 días"));

        inventario.agregarProveedor(new Proveedor(3, "PROV003", "Lácteos Tamaulipas",
                "Carlos Ruiz", "867-300-4000", "pedidos@lactamex.com",
                "Carretera Mante Km 5, Tampico", "LTA987654MNO", "15 días"));
    }
}