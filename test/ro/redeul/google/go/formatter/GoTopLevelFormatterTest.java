package ro.redeul.google.go.formatter;

/**
 * TODO: Document this.<br/>
 * <br/>
 *
 * Created on Dec-29-2013 22:27
 * @author <a href="mailto:mtoader@gmail.com">Mihai Toader</a>
 */
public class GoTopLevelFormatterTest extends GoFormatterTest {

    public void testBasic() throws Exception { doTest(); }

    @Override
    protected String getTestDataRelativePath() {
        return super.getTestDataRelativePath() + "toplevel/";
    }
}
