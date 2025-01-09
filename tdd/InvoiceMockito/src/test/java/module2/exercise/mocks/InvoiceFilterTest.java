package module2.exercise.mocks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Calendar;

class InvoiceFilterTest {
    private InvoiceFilter invoiceFilter;
    private InvoiceRepository repo;

    @BeforeEach
    public void setUp() {
        repo = Mockito.mock(InvoiceRepository.class);
        invoiceFilter = new InvoiceFilter(repo);
    }

    @Test
    void filter() {
        Invoice in1 = new Invoice(Calendar.getInstance(), "jirc", 4200);
        Invoice in2 = new Invoice(Calendar.getInstance(), "nini", 12);

        Mockito.when(repo.all()).thenReturn(Arrays.asList(in1, in2));

        var result = invoiceFilter.filter();

        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(in1, result.getFirst());
    }
}