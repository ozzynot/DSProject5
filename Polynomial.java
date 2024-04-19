class Polynomial {
    private String name;
    private DLList<Term> terms;

    public Polynomial(String name) {
        this.name = name;
        terms = new DLList<>();
    }

    public String getName() {
        return name;
    }

    public void insertTerm(Term term) {
        terms.insertLast(term);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name).append(" = ");

        boolean isFirstTerm = true;
        terms.first();
        while (true) {
            Term term = terms.dataRead();
            if (term == null) {
                break; // Break out of the loop when reaching the end of terms
            }
            int coefficient = term.getCoefficient();
            if (coefficient != 0) {
                if (!isFirstTerm) {
                    builder.append(coefficient > 0 ? " + " : " - ");
                }
                if (Math.abs(coefficient) != 1 || (term.getExponentX() == 0 && term.getExponentY() == 0 && term.getExponentZ() == 0)) {
                    builder.append(Math.abs(coefficient));
                }
                if (term.getExponentX() != 0) {
                    builder.append("(x");
                    if (term.getExponentX() != 1) {
                        builder.append("^").append(term.getExponentX());
                    }
                    builder.append(")");
                }
                if (term.getExponentY() != 0) {
                    builder.append("(y");
                    if (term.getExponentY() != 1) {
                        builder.append("^").append(term.getExponentY());
                    }
                    builder.append(")");
                }
                if (term.getExponentZ() != 0) {
                    builder.append("(z");
                    if (term.getExponentZ() != 1) {
                        builder.append("^").append(term.getExponentZ());
                    }
                    builder.append(")");
                }
                isFirstTerm = false; // Update isFirstTerm after appending the first term
            }
            if (!terms.next()) {
                break; // Break out of the loop if there are no more terms
            }
        }

        return builder.toString();
    }
}
