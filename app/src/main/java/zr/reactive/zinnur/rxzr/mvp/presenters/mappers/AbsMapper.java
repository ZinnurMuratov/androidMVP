package zr.reactive.zinnur.rxzr.mvp.presenters.mappers;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.functions.Func1;
import zr.reactive.zinnur.rxzr.mvp.models.dto.AbsDTO;
import zr.reactive.zinnur.rxzr.mvp.presenters.vo.AbsVO;

/**
 * Created by Zinnur on 29.10.16.
 */

public class AbsMapper implements Func1<List<AbsDTO>,List<AbsVO>> {

    @Inject
    public AbsMapper() {
    }

    @Override
    public List<AbsVO> call(List<AbsDTO> absDTOs) {
        if (absDTOs == null) {
            return null;
        }
        List <AbsVO> absVOs = Observable.from(absDTOs)
                .map(absDTO -> new AbsVO(absDTO.getStatus(),absDTO.getDescription()))
                .toList()
                .toBlocking()
                .first();
        return absVOs;
    }
}
