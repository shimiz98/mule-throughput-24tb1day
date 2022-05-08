package org.mule.extension.internal;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import java.io.IOException;
import java.io.InputStream;

import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;


/**
 * This class is a container for operations, every public method in this class will be taken as an extension operation.
 */
public class BasicOperations {

  @MediaType(MediaType.APPLICATION_OCTET_STREAM)
  public InputStream gernerateDummyData(String size) {
	  long reqSize;
	  if (size.endsWith("k") || size.endsWith("K")) {
		  reqSize = Long.parseLong(size.substring(0, size.length() - 1)) * 1024 * 1024 * 1024;
	  } else if (size.endsWith("m") || size.endsWith("M")) {
		  reqSize = Long.parseLong(size.substring(0, size.length() - 1)) * 1024 * 1024 * 1024;
	  } else if (size.endsWith("g") || size.endsWith("G")) {
		  reqSize = Long.parseLong(size.substring(0, size.length() - 1)) * 1024 * 1024 * 1024;
	  } else {
		  reqSize = Long.parseLong(size);
	  }

	  return new HexInputStream(reqSize);
  }
  
  private static class HexInputStream extends InputStream {
	private final long size;
	private long i = 0;
	public HexInputStream(long size) {
		this.size = size;
	}
	@Override
	public int read() throws IOException {
		if (size <= i) return -1;
		int h = (int)(i & 0xf);
		if (h <= 9) {
			h += '0';
		} else {
			h += 'a' - 10;
		}
		i += 1;
		return h;
	}
	  
  }
  /**
   * Example of an operation that uses the configuration and a connection instance to perform some action.
   */
  @MediaType(value = ANY, strict = false)
  public String retrieveInfo(@Config BasicConfiguration configuration, @Connection BasicConnection connection){
    return "Using Configuration [" + configuration.getConfigId() + "] with Connection id [" + connection.getId() + "]";
  }

  /**
   * Example of a simple operation that receives a string parameter and returns a new string message that will be set on the payload.
   */
  @MediaType(value = ANY, strict = false)
  public String sayHi(String person) {
    return buildHelloMessage(person);
  }

  /**
   * Private Methods are not exposed as operations
   */
  private String buildHelloMessage(String person) {
    return "Hello " + person + "!!!";
  }
}
