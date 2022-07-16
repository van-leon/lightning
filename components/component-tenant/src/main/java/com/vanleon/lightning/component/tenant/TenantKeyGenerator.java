package com.vanleon.lightning.component.tenant;

import java.util.Objects;

public interface TenantKeyGenerator {

    default String generateDefault(Objects... params) {
        return generate(SeparatorEnum.COLON.getValue(), (Object[]) params);
    }

    default String generate(String separator, Object... params) {
        TenantContext tenantContext = TenantContextHolder.get();
        String tenantId = tenantContext.getTenantId();

        StringBuilder sb = new StringBuilder();
        sb.append(tenantId);
        for (int i = 0, length = params.length; i < length; i++) {
            if (i <= length - 1) {
                sb.append(separator);
            }
            sb.append(params[i]);
        }
        return sb.toString();
    }

    enum SeparatorEnum {
        COMMA(","),
        DOT("."),
        COLON(":"),
        HYPHEN("-"),
        UNDERSCORE("_"),
        ;

        private final String value;

        SeparatorEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }
}
