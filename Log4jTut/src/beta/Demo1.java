package beta;
import org.apache.logging.log4j.*;

public class Demo1 {

	private static Logger log =LogManager.getLogger(Demo1.class.getName());
	public static void main(String[] args) {
		// TODO Auto-generated method stub
log.debug("I m debugging");
log.info("object is present");
log.error("object is not present");
log.fatal("object is fatal");

	}

}
