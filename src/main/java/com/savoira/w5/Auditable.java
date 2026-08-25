package com.savoira.w5;

public interface Auditable {

    default String auditPrefix() {
        return "[AUDIT] ";
    }

    String getAuditSummary();
}