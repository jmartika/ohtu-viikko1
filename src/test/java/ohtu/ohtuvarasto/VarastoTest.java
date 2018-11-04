package ohtu.ohtuvarasto;

import org.junit.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class VarastoTest {

    Varasto varasto;
    Varasto varasto2;
    Varasto kellari;
    Varasto ullakko;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        varasto = new Varasto(10);
        kellari = new Varasto(-110,-10);
        ullakko = new Varasto(10,100);
        varasto2 = new Varasto(-2);
    }

    @Test
    public void konstruktoriLuoTyhjanVaraston() {
        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriLuoTyhjanKellarin() {
        assertEquals(0, kellari.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void konstruktoriLuoOikein() {
        assertEquals(10, ullakko.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void konstruktoriLuoOikeanVaraston() {
        assertEquals(0, varasto2.getSaldo(), vertailuTarkkuus);
    }
    @Test
    public void uudellaVarastollaOikeaTilavuus() {
        assertEquals(10, varasto.getTilavuus(), vertailuTarkkuus);
    }
    
    @Test
    public void uudellaKellarillaOikeaTilavuus() {
        assertEquals(0, kellari.getTilavuus(), vertailuTarkkuus);
    }

    @Test
    public void lisaysLisaaSaldoa() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }

     @Test
    public void lisaysLisaaSaldoa2() {
        varasto.lisaaVarastoon(8);

        // saldon pitäisi olla sama kun lisätty määrä
        assertEquals(8, varasto.getSaldo(), vertailuTarkkuus);
    }
    @Test
    public void lisaysLisaaPienentaaVapaataTilaa() {
        varasto.lisaaVarastoon(8);

        // vapaata tilaa pitäisi vielä olla tilavuus-lisättävä määrä eli 2
        assertEquals(2, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }


    @Test
    public void ottaminenLisääTilaa() {
        varasto.lisaaVarastoon(8);

        varasto.otaVarastosta(2);

        // varastossa pitäisi olla tilaa 10 - 8 + 2 eli 4
        assertEquals(4, varasto.paljonkoMahtuu(), vertailuTarkkuus);
    }
    
  

    @Test
    public void saldoEiYlity() {
        varasto.lisaaVarastoon(11);



        assertEquals(10, varasto.getSaldo(), vertailuTarkkuus);
    }

    @Test
    public void saldoEiAlitu() {
        varasto.otaVarastosta(11);


        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void oikeaTulostus() {


        assertEquals("saldo = 0.0, vielä tilaa 10.0", varasto.toString());
    }
    
    @Test
    public void vaaraSaldo1() {
        varasto.otaVarastosta(-11);

        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
    
    @Test
    public void vaaraSaldo2() {
        varasto.lisaaVarastoon(-11);

        assertEquals(0, varasto.getSaldo(), vertailuTarkkuus);
    }
}