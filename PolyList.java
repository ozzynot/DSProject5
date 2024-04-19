class PolyList {
    private DLList<Polynomial> polynomials;

    public PolyList() {
        polynomials = new DLList<>();
    }

    public void insertPolynomial(Polynomial polynomial) {
        polynomials.insertLast(polynomial);
    }

    public Polynomial searchPolynomial(String name) {
        polynomials.first();
        while (polynomials.dataRead() != null) {
            Polynomial polynomial = polynomials.dataRead();
            if (polynomial.getName().equals(name)) {
                return polynomial;
            }
            polynomials.next();
        }
        return null;
    }

    public void deletePolynomial(String name) {
        polynomials.first();
        while (polynomials.dataRead() != null) {
            Polynomial polynomial = polynomials.dataRead();
            if (polynomial.getName().equals(name)) {
                polynomials.deleteAtCurrent();
                return;
            }
            polynomials.next();
        }
    }
}
