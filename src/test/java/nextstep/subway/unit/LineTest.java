package nextstep.subway.unit;

import nextstep.subway.domain.Line;
import nextstep.subway.domain.Station;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LineTest {

    @DisplayName("구간 목록 마지막에 새로운 구간을 추가할 경우")
    @Test
    void addSection() {

        // given
        String 일호선 = "1호선";
        String 파란색 = "파란색";
        String 동암역 = "동암역";
        String 부평역 = "부평역";

        Line 일호선_노선 = new Line(
                일호선,
                파란색
        );


        // when
        일호선_노선.addSection(
                일호선_노선,
                new Station(동암역),
                new Station(부평역),
                10
        );

        // then
        int 일호선_구간_개수 = 일호선_노선.getSections()
                              .size();

        String 일호선_첫번째_구간의_상행역 = 일호선_노선.getSections()
                                       .get(0)
                                       .getUpStation()
                                       .getName();
        String 일호선_첫번째_구간의_하행역 = 일호선_노선.getSections()
                                       .get(0)
                                       .getDownStation()
                                       .getName();

        int 일호선_첫번째_구간의_거리 = 일호선_노선.getSections()
                                   .get(0)
                                   .getDistance();

        assertAll(
                () -> assertThat(일호선_구간_개수).isEqualTo(1),
                () -> assertThat(일호선_첫번째_구간의_상행역).isEqualTo(동암역),
                () -> assertThat(일호선_첫번째_구간의_하행역).isEqualTo(부평역),
                () -> assertThat(일호선_첫번째_구간의_거리).isEqualTo(10)
        );
    }

    @DisplayName("노선에 속해있는 역 목록 조회")
    @Test
    void getStations() {
    }

    @DisplayName("구간이 목록에서 마지막 역 삭제")
    @Test
    void removeSection() {
    }
}
