import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;


public class URLModel {
	private URL url;
	
	public URLModel(String urlString) {
		try{
			this.url = new URL(urlString);
		} catch (MalformedURLException e) {
			this.url = null;
		}
		if(url != null) {
			try{
				url.toURI();
			} catch (URISyntaxException e) {
				this.url = null;
			}
		}		
	}
	
	public URL getURL() {
		return url;
	}
	
	public boolean isValid() {
		return url != null;
	}
		
	public URL getCanonicalized() throws MalformedURLException {
		if(url == null)
			return null;
		return new URL(url.getProtocol(), url.getHost(), url.getFile());
	}
}
