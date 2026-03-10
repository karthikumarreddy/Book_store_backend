package com.bookstore.api;

/**
 * Pagination metadata carrier.
 * Package: com.bookstore.api  (matches compiled WAR structure)
 *
 * Fields confirmed from WAR bytecode:
 *   page | size | totalElements | totalPages | hasNext | hasPrevious
 */
public class Meta {

    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean hasNext;
    private boolean hasPrevious;

    private Meta() {}

    // ─── Builder ──────────────────────────────────────────────────────────────

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final Meta meta;

        private Builder() {
            this.meta = new Meta();
        }

        public Builder page(int page) {
            meta.page = page;
            return this;
        }

        public Builder size(int size) {
            meta.size = size;
            return this;
        }

        public Builder totalElements(long totalElements) {
            meta.totalElements = totalElements;
            return this;
        }

        public Builder totalPages(int totalPages) {
            meta.totalPages = totalPages;
            return this;
        }

        public Meta build() {
            meta.hasNext     = meta.page < meta.totalPages - 1;
            meta.hasPrevious = meta.page > 0;
            return meta;
        }
    }

    // ─── Convenience factory (Spring Data Page<T> shortcut) ───────────────────

    /**
     * Usage in controllers:
     *   Meta meta = Meta.of(page.getNumber(), page.getSize(),
     *                       page.getTotalElements(), page.getTotalPages());
     */
    public static Meta of(int page, int size, long totalElements, int totalPages) {
        return Meta.builder()
                .page(page)
                .size(size)
                .totalElements(totalElements)
                .totalPages(totalPages)
                .build();
    }

    // ─── Getters ──────────────────────────────────────────────────────────────

    public int getPage()           { return page;          }
    public int getSize()           { return size;          }
    public long getTotalElements() { return totalElements; }
    public int getTotalPages()     { return totalPages;    }
    public boolean isHasNext()     { return hasNext;       }
    public boolean isHasPrevious() { return hasPrevious;   }
}
