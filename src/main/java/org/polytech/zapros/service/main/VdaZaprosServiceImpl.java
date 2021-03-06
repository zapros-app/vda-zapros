package org.polytech.zapros.service.main;

import java.util.List;

import org.polytech.zapros.bean.Alternative;
import org.polytech.zapros.bean.alternative.AlternativeRankingResult;
import org.polytech.zapros.bean.Answer;
import org.polytech.zapros.bean.Answer.AnswerType;
import org.polytech.zapros.bean.AnswerCheckResult;
import org.polytech.zapros.bean.BuildingQesCheckResult;
import org.polytech.zapros.bean.Criteria;
import org.polytech.zapros.bean.QuasiExpert;
import org.polytech.zapros.bean.QuasiExpertConfig;
import org.polytech.zapros.bean.ReplacedAnswer;
import org.polytech.zapros.service.answer.AnswerService;
import org.polytech.zapros.service.qe.QuasiExpertService;
import org.polytech.zapros.service.ranking.AlternativeRankingService;

public abstract class VdaZaprosServiceImpl implements VdaZaprosService {

    private final AnswerService answerService;
    private final QuasiExpertService quasiExpertService;
    private final AlternativeRankingService alternativeRankingService;

    public VdaZaprosServiceImpl(AnswerService answerService, QuasiExpertService quasiExpertService, AlternativeRankingService alternativeRankingService) {
        this.answerService = answerService;
        this.quasiExpertService = quasiExpertService;
        this.alternativeRankingService = alternativeRankingService;
    }

    @Override
    public final AnswerCheckResult askFirst(List<Criteria> criteriaList) {
        return answerService.askFirst(criteriaList);
    }

    @Override
    public final AnswerCheckResult addAnswer(AnswerCheckResult checkResult, AnswerType answerType) {
        return answerService.addAnswer(checkResult, answerType);
    }

    @Override
    public BuildingQesCheckResult buildQes(List<Answer> answerList, QuasiExpertConfig config, List<Criteria> criteriaList, Double threshold) {
        return quasiExpertService.buildQes(answerList, config, criteriaList, threshold);
    }

    @Override
    public ReplacedAnswer replaceAnswer(BuildingQesCheckResult checkResult, AnswerType answerType) {
        return answerService.replaceAnswer(checkResult, answerType);
    }

    @Override
    public AlternativeRankingResult rankAlternatives(List<QuasiExpert> qes, List<Alternative> alternativeList, List<Criteria> criteriaList, QuasiExpertConfig config) {
        return alternativeRankingService.rankAlternatives(qes, alternativeList, criteriaList, config);
    }
}
