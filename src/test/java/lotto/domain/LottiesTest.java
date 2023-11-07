package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottiesTest {
    @DisplayName("Lotto List 를 반환할 땐 unmodifiedList 를 반환")
    @Test
    public void returnLottoListAsUnmodifiable(){
        Lotties lotties = new Lotties(List.of(new Lotto(List.of(1,2,3,4,5,6))));
        List<Lotto> valueLotto = lotties.getLotties();
        assertThatThrownBy(
                ()-> valueLotto.add(new Lotto(List.of(1,2,3,4,5,6)))
        ).isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName(" 로또 리스트를 바탕으로 lotties 생성")
    @Test
    public void createLotties(){
        List<Lotto> lottos = List.of(new Lotto(List.of(1,2,3,4,5,6)));
        Lotties lotties = new Lotties(lottos);
        assertThat(lotties.getLotties()).isEqualTo(lottos);
    }

    @DisplayName("로또 리스트를 바탕으로 만들어진 lotties size 검증 ")
    @Test
    public void testSize() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),
                new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18))
        );
        Lotties lotties = new Lotties(new ArrayList<>(lottos));
        int expectedSize = lottos.size();
        int actualSize = lotties.size();
        assertEquals(expectedSize, actualSize);
    }
}