package steps;

import page.CursosPage;

public class CursosSteps {

    private final CursosPage cursosPage;

    public CursosSteps() {
        cursosPage = new CursosPage();
    }

    public void seleccionarCurso(String arg0) {
        String cursoXPath = "//ul[@class='css-1t5l7tc-view--block-list']/li/a[contains(text(),'" + arg0 + "')]";
        cursosPage.seleccionarCurso(cursoXPath);
    }
}
