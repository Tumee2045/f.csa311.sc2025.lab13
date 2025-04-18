package AndrewWebServices;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;


import org.junit.Before;
import org.junit.Test;

public class AndrewWebServicesTest {
    Database database;
    RecSys recommender;
    PromoService promoService;
    AndrewWebServices andrewWebService;

    @Before
    public void setUp() {

    }

    @Test
    public void testLogIn() {
        // This is taking way too long to test
        InMemoryDatabase fakeDb = new InMemoryDatabase();
        fakeDb.addUser("Scotty", 17214);
        andrewWebService = new AndrewWebServices(fakeDb, recommender, promoService);
        assertTrue(andrewWebService.logIn("Scotty", 17214));
    }

    @Test
    public void testGetRecommendation() {
        // This is taking way too long to test
        StubRecSys stubRecSys = new StubRecSys();
    andrewWebService = new AndrewWebServices(database, stubRecSys, promoService);
    assertEquals("The Matrix", andrewWebService.getRecommendation("Scotty"));
    }

    @Test
    public void testSendEmail() {
    PromoService mockPromo = mock(PromoService.class);
    andrewWebService = new AndrewWebServices(database, recommender, mockPromo);

    andrewWebService.sendPromoEmail("user@example.com");

    verify(mockPromo).mailTo("user@example.com");
    }

    @Test
    public void testNoSendEmail() {
        InMemoryDatabase fakeDb = new InMemoryDatabase();
        fakeDb.addUser("Scotty", 17214);
    
        PromoService mockPromo = mock(PromoService.class);
        andrewWebService = new AndrewWebServices(fakeDb, recommender, mockPromo);
    
        andrewWebService.logIn("Scotty", 17214);  // Just logging in, no email
    
        verify(mockPromo, never()).mailTo(anyString());
    }
}
