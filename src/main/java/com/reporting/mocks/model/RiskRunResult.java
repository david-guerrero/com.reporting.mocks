package com.reporting.mocks.model;

import com.reporting.mocks.model.risks.Risk;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class RiskRunResult {
    protected UUID id;
    protected Date date;
    protected ResultKind kind;
    protected int fragmentCount;
    protected int fragmentNo;
    protected RiskRunRequest request;
    protected List<Risk> risks;



    public RiskRunResult(ResultKind kind, int fragmentCount, int fragmentNo, RiskRunRequest request, List<Risk> risks) {
        this.id = UUID.randomUUID();
        this.request = request;
        this.risks = risks;
        this.date = new Date();
        this.kind = kind;
        this.fragmentCount = fragmentCount;
        this.fragmentNo = fragmentNo;

    }

    public RiskRunResult(RiskRunRequest request, List<Risk> risks) {
        this(ResultKind.Complete, 1, 0, request, risks);
    }

    public UUID getId() {
        return id;
    }

    public RiskRunRequest getRequest() {
        return request;
    }

    public Date getDate() {
        return date;
    }

    public ResultKind getKind() {
        return kind;
    }

    public int getFragmentCount() {
        return fragmentCount;
    }

    public int getFragmentNo() {
        return fragmentNo;
    }

    public List<Risk> getRisks() {
        return risks;
    }


}