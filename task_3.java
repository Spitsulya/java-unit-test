@RunWith(Parameterized.class) // Напиши аннотацию для параметризованных тестов

public class CheckIsAdultTest {

    private final int age;
    private final boolean result;

    public CheckIsAdultTest(int age, boolean result) {
        this.age = age; // Инициализируй поля класса в конструкторе
        this.result = result;
    }

    @Parameterized.Parameters // Пометь метод аннотацией для параметров
    public static Object[][] getTextData() {
        return new Object[][] {
                {17, false}, // Младше 18
                {18, true},  // Совершеннолетие
                {21, true},  // Совершеннолетие в некоторых странах
                {100, true}  // Пожилой возраст
        };
    }

    @Test
    public void checkIsAdultWhenAgeThenResult() {
        Program program = new Program();
        boolean isAdult = program.checkIsAdult(age);
        // Сравни полученный и ожидаемый результаты, не забудь про сообщение об ошибке
        assertEquals("Ошибочка", result, isAdult);
    }
}