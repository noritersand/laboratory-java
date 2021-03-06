package thirdparty.apache.commons;

import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 
 * @since 2017-07-27
 * @author fixalot
 */
public class SystemUtilsTest {
//	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(SystemUtilsTest.class);

	@Test
	public void test() {
		logger.debug("{}", SystemUtils.IS_OS_WINDOWS);
		logger.debug("{}", SystemUtils.IS_OS_UNIX);
		logger.debug("{}", SystemUtils.IS_OS_LINUX);
		logger.debug("{}", SystemUtils.IS_OS_MAC);
		logger.debug("{}", SystemUtils.FILE_ENCODING);
	}
}
