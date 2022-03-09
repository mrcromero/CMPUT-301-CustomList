import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

import com.example.simpleparadox.listycity.City;
import com.example.simpleparadox.listycity.CustomList;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    @Before
    public void createList() {
        list = new CustomList(null, new ArrayList<City>());
    }

    @Test
    public void addCityTest() {
        int listSize = list.getCount();
        list.addCity(new City("Edmonton", "AB"));
        assertEquals(list.getCount(), listSize + 1);
    }

    @Test
    public void hasCityTest() {
        City testCity = new City("Edmonton", "AB");
        list.addCity(testCity);
        assertTrue(list.hasCity(testCity));
    }

    @Test
    public void deleteCityTest() {
        City testCity = new City("Edmonton", "AB");
        list.addCity(testCity);
        int listSize = list.getCount();
        list.deleteCity(testCity);
        assertEquals(list.getCount(), listSize - 1);
    }

    @Test
    public void countCitiesTest() {
        String []cityNames = {"Edmonton", "Calgary", "Vancouver", "Montreal"};
        String []provinceNames = {"AB", "AB", "BC", "QC"};
        for (int i=0; i < cityNames.length; i++) {
            list.addCity(new City(cityNames[i], provinceNames[i]));
        }

        assertEquals(list.countCities(), cityNames.length);

    }
}
