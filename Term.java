class Term {
    private int coefficient;
    private int exponentX;
    private int exponentY;
    private int exponentZ;

    public Term(int coefficient, int exponentX, int exponentY, int exponentZ) {
        this.coefficient = coefficient;
        this.exponentX = exponentX;
        this.exponentY = exponentY;
        this.exponentZ = exponentZ;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public int getExponentX() {
        return exponentX;
    }

    public int getExponentY() {
        return exponentY;
    }

    public int getExponentZ() {
        return exponentZ;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (coefficient != 0) {
            if (coefficient == 1 && exponentX == 0 && exponentY == 0 && exponentZ == 0) {
                builder.append("1");
            } else if (coefficient == -1 && exponentX == 0 && exponentY == 0 && exponentZ == 0) {
                builder.append("-1");
            } else if (coefficient != 1 && coefficient != -1) {
                builder.append(coefficient);
            }

            if (exponentX != 0) {
                builder.append("(x");
                if (exponentX != 1) {
                    builder.append("^").append(exponentX);
                }
                builder.append(")");
            }

            if (exponentY != 0) {
                builder.append("(y");
                if (exponentY != 1) {
                    builder.append("^").append(exponentY);
                }
                builder.append(")");
            }

            if (exponentZ != 0) {
                builder.append("(z");
                if (exponentZ != 1) {
                    builder.append("^").append(exponentZ);
                }
                builder.append(")");
            }
        }

        return builder.toString();
    }
}
