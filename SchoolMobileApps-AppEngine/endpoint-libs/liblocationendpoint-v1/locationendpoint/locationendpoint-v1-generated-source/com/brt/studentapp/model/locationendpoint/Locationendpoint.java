/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://code.google.com/p/google-apis-client-generator/
 * (build: 2014-07-22 21:53:01 UTC)
 * on 2014-10-20 at 09:40:23 UTC 
 * Modify at your own risk.
 */

package com.brt.studentapp.model.locationendpoint;

/**
 * Service definition for Locationendpoint (v1).
 *
 * <p>
 * This is an API
 * </p>
 *
 * <p>
 * For more information about this service, see the
 * <a href="" target="_blank">API Documentation</a>
 * </p>
 *
 * <p>
 * This service uses {@link LocationendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Locationendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.18.0-rc of the locationendpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
  }

  /**
   * The default encoded root URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_ROOT_URL = "https://hzb-branch-721.appspot.com/_ah/api/";

  /**
   * The default encoded service path of the service. This is determined when the library is
   * generated and normally should not be changed.
   *
   * @since 1.7
   */
  public static final String DEFAULT_SERVICE_PATH = "locationendpoint/v1/";

  /**
   * The default encoded base URL of the service. This is determined when the library is generated
   * and normally should not be changed.
   */
  public static final String DEFAULT_BASE_URL = DEFAULT_ROOT_URL + DEFAULT_SERVICE_PATH;

  /**
   * Constructor.
   *
   * <p>
   * Use {@link Builder} if you need to specify any of the optional parameters.
   * </p>
   *
   * @param transport HTTP transport, which should normally be:
   *        <ul>
   *        <li>Google App Engine:
   *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
   *        <li>Android: {@code newCompatibleTransport} from
   *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
   *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
   *        </li>
   *        </ul>
   * @param jsonFactory JSON factory, which may be:
   *        <ul>
   *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
   *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
   *        <li>Android Honeycomb or higher:
   *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
   *        </ul>
   * @param httpRequestInitializer HTTP request initializer or {@code null} for none
   * @since 1.7
   */
  public Locationendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Locationendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getLocation".
   *
   * This request holds the parameters needed by the locationendpoint server.  After setting any
   * optional parameters, call the {@link GetLocation#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public GetLocation getLocation(java.lang.Long id) throws java.io.IOException {
    GetLocation result = new GetLocation(id);
    initialize(result);
    return result;
  }

  public class GetLocation extends LocationendpointRequest<com.brt.studentapp.model.locationendpoint.model.Location> {

    private static final String REST_PATH = "get_location";

    /**
     * Create a request for the method "getLocation".
     *
     * This request holds the parameters needed by the the locationendpoint server.  After setting any
     * optional parameters, call the {@link GetLocation#execute()} method to invoke the remote
     * operation. <p> {@link
     * GetLocation#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetLocation(java.lang.Long id) {
      super(Locationendpoint.this, "GET", REST_PATH, null, com.brt.studentapp.model.locationendpoint.model.Location.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetLocation setAlt(java.lang.String alt) {
      return (GetLocation) super.setAlt(alt);
    }

    @Override
    public GetLocation setFields(java.lang.String fields) {
      return (GetLocation) super.setFields(fields);
    }

    @Override
    public GetLocation setKey(java.lang.String key) {
      return (GetLocation) super.setKey(key);
    }

    @Override
    public GetLocation setOauthToken(java.lang.String oauthToken) {
      return (GetLocation) super.setOauthToken(oauthToken);
    }

    @Override
    public GetLocation setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetLocation) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetLocation setQuotaUser(java.lang.String quotaUser) {
      return (GetLocation) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetLocation setUserIp(java.lang.String userIp) {
      return (GetLocation) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public GetLocation setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public GetLocation set(String parameterName, Object value) {
      return (GetLocation) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "getLocationByKey".
   *
   * This request holds the parameters needed by the locationendpoint server.  After setting any
   * optional parameters, call the {@link GetLocationByKey#execute()} method to invoke the remote
   * operation.
   *
   * @param kind
   * @param name
   * @return the request
   */
  public GetLocationByKey getLocationByKey(java.lang.String kind, java.lang.String name) throws java.io.IOException {
    GetLocationByKey result = new GetLocationByKey(kind, name);
    initialize(result);
    return result;
  }

  public class GetLocationByKey extends LocationendpointRequest<com.brt.studentapp.model.locationendpoint.model.Location> {

    private static final String REST_PATH = "get_location_by_key";

    /**
     * Create a request for the method "getLocationByKey".
     *
     * This request holds the parameters needed by the the locationendpoint server.  After setting any
     * optional parameters, call the {@link GetLocationByKey#execute()} method to invoke the remote
     * operation. <p> {@link GetLocationByKey#initialize(com.google.api.client.googleapis.services.Abs
     * tractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @param kind
     * @param name
     * @since 1.13
     */
    protected GetLocationByKey(java.lang.String kind, java.lang.String name) {
      super(Locationendpoint.this, "GET", REST_PATH, null, com.brt.studentapp.model.locationendpoint.model.Location.class);
      this.kind = com.google.api.client.util.Preconditions.checkNotNull(kind, "Required parameter kind must be specified.");
      this.name = com.google.api.client.util.Preconditions.checkNotNull(name, "Required parameter name must be specified.");
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public GetLocationByKey setAlt(java.lang.String alt) {
      return (GetLocationByKey) super.setAlt(alt);
    }

    @Override
    public GetLocationByKey setFields(java.lang.String fields) {
      return (GetLocationByKey) super.setFields(fields);
    }

    @Override
    public GetLocationByKey setKey(java.lang.String key) {
      return (GetLocationByKey) super.setKey(key);
    }

    @Override
    public GetLocationByKey setOauthToken(java.lang.String oauthToken) {
      return (GetLocationByKey) super.setOauthToken(oauthToken);
    }

    @Override
    public GetLocationByKey setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetLocationByKey) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetLocationByKey setQuotaUser(java.lang.String quotaUser) {
      return (GetLocationByKey) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetLocationByKey setUserIp(java.lang.String userIp) {
      return (GetLocationByKey) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String kind;

    /**

     */
    public java.lang.String getKind() {
      return kind;
    }

    public GetLocationByKey setKind(java.lang.String kind) {
      this.kind = kind;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.String name;

    /**

     */
    public java.lang.String getName() {
      return name;
    }

    public GetLocationByKey setName(java.lang.String name) {
      this.name = name;
      return this;
    }

    @Override
    public GetLocationByKey set(String parameterName, Object value) {
      return (GetLocationByKey) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertLocation".
   *
   * This request holds the parameters needed by the locationendpoint server.  After setting any
   * optional parameters, call the {@link InsertLocation#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.brt.studentapp.model.locationendpoint.model.Location}
   * @return the request
   */
  public InsertLocation insertLocation(com.brt.studentapp.model.locationendpoint.model.Location content) throws java.io.IOException {
    InsertLocation result = new InsertLocation(content);
    initialize(result);
    return result;
  }

  public class InsertLocation extends LocationendpointRequest<com.brt.studentapp.model.locationendpoint.model.Location> {

    private static final String REST_PATH = "insert_location";

    /**
     * Create a request for the method "insertLocation".
     *
     * This request holds the parameters needed by the the locationendpoint server.  After setting any
     * optional parameters, call the {@link InsertLocation#execute()} method to invoke the remote
     * operation. <p> {@link InsertLocation#initialize(com.google.api.client.googleapis.services.Abstr
     * actGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param content the {@link com.brt.studentapp.model.locationendpoint.model.Location}
     * @since 1.13
     */
    protected InsertLocation(com.brt.studentapp.model.locationendpoint.model.Location content) {
      super(Locationendpoint.this, "POST", REST_PATH, content, com.brt.studentapp.model.locationendpoint.model.Location.class);
    }

    @Override
    public InsertLocation setAlt(java.lang.String alt) {
      return (InsertLocation) super.setAlt(alt);
    }

    @Override
    public InsertLocation setFields(java.lang.String fields) {
      return (InsertLocation) super.setFields(fields);
    }

    @Override
    public InsertLocation setKey(java.lang.String key) {
      return (InsertLocation) super.setKey(key);
    }

    @Override
    public InsertLocation setOauthToken(java.lang.String oauthToken) {
      return (InsertLocation) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertLocation setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertLocation) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertLocation setQuotaUser(java.lang.String quotaUser) {
      return (InsertLocation) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertLocation setUserIp(java.lang.String userIp) {
      return (InsertLocation) super.setUserIp(userIp);
    }

    @Override
    public InsertLocation set(String parameterName, Object value) {
      return (InsertLocation) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listLocation".
   *
   * This request holds the parameters needed by the locationendpoint server.  After setting any
   * optional parameters, call the {@link ListLocation#execute()} method to invoke the remote
   * operation.
   *
   * @return the request
   */
  public ListLocation listLocation() throws java.io.IOException {
    ListLocation result = new ListLocation();
    initialize(result);
    return result;
  }

  public class ListLocation extends LocationendpointRequest<com.brt.studentapp.model.locationendpoint.model.CollectionResponseLocation> {

    private static final String REST_PATH = "list_location";

    /**
     * Create a request for the method "listLocation".
     *
     * This request holds the parameters needed by the the locationendpoint server.  After setting any
     * optional parameters, call the {@link ListLocation#execute()} method to invoke the remote
     * operation. <p> {@link
     * ListLocation#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected ListLocation() {
      super(Locationendpoint.this, "GET", REST_PATH, null, com.brt.studentapp.model.locationendpoint.model.CollectionResponseLocation.class);
    }

    @Override
    public com.google.api.client.http.HttpResponse executeUsingHead() throws java.io.IOException {
      return super.executeUsingHead();
    }

    @Override
    public com.google.api.client.http.HttpRequest buildHttpRequestUsingHead() throws java.io.IOException {
      return super.buildHttpRequestUsingHead();
    }

    @Override
    public ListLocation setAlt(java.lang.String alt) {
      return (ListLocation) super.setAlt(alt);
    }

    @Override
    public ListLocation setFields(java.lang.String fields) {
      return (ListLocation) super.setFields(fields);
    }

    @Override
    public ListLocation setKey(java.lang.String key) {
      return (ListLocation) super.setKey(key);
    }

    @Override
    public ListLocation setOauthToken(java.lang.String oauthToken) {
      return (ListLocation) super.setOauthToken(oauthToken);
    }

    @Override
    public ListLocation setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListLocation) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListLocation setQuotaUser(java.lang.String quotaUser) {
      return (ListLocation) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListLocation setUserIp(java.lang.String userIp) {
      return (ListLocation) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String cursor;

    /**

     */
    public java.lang.String getCursor() {
      return cursor;
    }

    public ListLocation setCursor(java.lang.String cursor) {
      this.cursor = cursor;
      return this;
    }

    @com.google.api.client.util.Key
    private java.lang.Integer limit;

    /**

     */
    public java.lang.Integer getLimit() {
      return limit;
    }

    public ListLocation setLimit(java.lang.Integer limit) {
      this.limit = limit;
      return this;
    }

    @Override
    public ListLocation set(String parameterName, Object value) {
      return (ListLocation) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeLocation".
   *
   * This request holds the parameters needed by the locationendpoint server.  After setting any
   * optional parameters, call the {@link RemoveLocation#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public RemoveLocation removeLocation(java.lang.Long id) throws java.io.IOException {
    RemoveLocation result = new RemoveLocation(id);
    initialize(result);
    return result;
  }

  public class RemoveLocation extends LocationendpointRequest<Void> {

    private static final String REST_PATH = "remove_location";

    /**
     * Create a request for the method "removeLocation".
     *
     * This request holds the parameters needed by the the locationendpoint server.  After setting any
     * optional parameters, call the {@link RemoveLocation#execute()} method to invoke the remote
     * operation. <p> {@link RemoveLocation#initialize(com.google.api.client.googleapis.services.Abstr
     * actGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveLocation(java.lang.Long id) {
      super(Locationendpoint.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveLocation setAlt(java.lang.String alt) {
      return (RemoveLocation) super.setAlt(alt);
    }

    @Override
    public RemoveLocation setFields(java.lang.String fields) {
      return (RemoveLocation) super.setFields(fields);
    }

    @Override
    public RemoveLocation setKey(java.lang.String key) {
      return (RemoveLocation) super.setKey(key);
    }

    @Override
    public RemoveLocation setOauthToken(java.lang.String oauthToken) {
      return (RemoveLocation) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveLocation setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveLocation) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveLocation setQuotaUser(java.lang.String quotaUser) {
      return (RemoveLocation) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveLocation setUserIp(java.lang.String userIp) {
      return (RemoveLocation) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public RemoveLocation setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveLocation set(String parameterName, Object value) {
      return (RemoveLocation) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateLocation".
   *
   * This request holds the parameters needed by the locationendpoint server.  After setting any
   * optional parameters, call the {@link UpdateLocation#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.brt.studentapp.model.locationendpoint.model.Location}
   * @return the request
   */
  public UpdateLocation updateLocation(com.brt.studentapp.model.locationendpoint.model.Location content) throws java.io.IOException {
    UpdateLocation result = new UpdateLocation(content);
    initialize(result);
    return result;
  }

  public class UpdateLocation extends LocationendpointRequest<com.brt.studentapp.model.locationendpoint.model.Location> {

    private static final String REST_PATH = "update_location";

    /**
     * Create a request for the method "updateLocation".
     *
     * This request holds the parameters needed by the the locationendpoint server.  After setting any
     * optional parameters, call the {@link UpdateLocation#execute()} method to invoke the remote
     * operation. <p> {@link UpdateLocation#initialize(com.google.api.client.googleapis.services.Abstr
     * actGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param content the {@link com.brt.studentapp.model.locationendpoint.model.Location}
     * @since 1.13
     */
    protected UpdateLocation(com.brt.studentapp.model.locationendpoint.model.Location content) {
      super(Locationendpoint.this, "PUT", REST_PATH, content, com.brt.studentapp.model.locationendpoint.model.Location.class);
    }

    @Override
    public UpdateLocation setAlt(java.lang.String alt) {
      return (UpdateLocation) super.setAlt(alt);
    }

    @Override
    public UpdateLocation setFields(java.lang.String fields) {
      return (UpdateLocation) super.setFields(fields);
    }

    @Override
    public UpdateLocation setKey(java.lang.String key) {
      return (UpdateLocation) super.setKey(key);
    }

    @Override
    public UpdateLocation setOauthToken(java.lang.String oauthToken) {
      return (UpdateLocation) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateLocation setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateLocation) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateLocation setQuotaUser(java.lang.String quotaUser) {
      return (UpdateLocation) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateLocation setUserIp(java.lang.String userIp) {
      return (UpdateLocation) super.setUserIp(userIp);
    }

    @Override
    public UpdateLocation set(String parameterName, Object value) {
      return (UpdateLocation) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Locationendpoint}.
   *
   * <p>
   * Implementation is not thread-safe.
   * </p>
   *
   * @since 1.3.0
   */
  public static final class Builder extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient.Builder {

    /**
     * Returns an instance of a new builder.
     *
     * @param transport HTTP transport, which should normally be:
     *        <ul>
     *        <li>Google App Engine:
     *        {@code com.google.api.client.extensions.appengine.http.UrlFetchTransport}</li>
     *        <li>Android: {@code newCompatibleTransport} from
     *        {@code com.google.api.client.extensions.android.http.AndroidHttp}</li>
     *        <li>Java: {@link com.google.api.client.googleapis.javanet.GoogleNetHttpTransport#newTrustedTransport()}
     *        </li>
     *        </ul>
     * @param jsonFactory JSON factory, which may be:
     *        <ul>
     *        <li>Jackson: {@code com.google.api.client.json.jackson2.JacksonFactory}</li>
     *        <li>Google GSON: {@code com.google.api.client.json.gson.GsonFactory}</li>
     *        <li>Android Honeycomb or higher:
     *        {@code com.google.api.client.extensions.android.json.AndroidJsonFactory}</li>
     *        </ul>
     * @param httpRequestInitializer HTTP request initializer or {@code null} for none
     * @since 1.7
     */
    public Builder(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
        com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      super(
          transport,
          jsonFactory,
          DEFAULT_ROOT_URL,
          DEFAULT_SERVICE_PATH,
          httpRequestInitializer,
          false);
    }

    /** Builds a new instance of {@link Locationendpoint}. */
    @Override
    public Locationendpoint build() {
      return new Locationendpoint(this);
    }

    @Override
    public Builder setRootUrl(String rootUrl) {
      return (Builder) super.setRootUrl(rootUrl);
    }

    @Override
    public Builder setServicePath(String servicePath) {
      return (Builder) super.setServicePath(servicePath);
    }

    @Override
    public Builder setHttpRequestInitializer(com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
      return (Builder) super.setHttpRequestInitializer(httpRequestInitializer);
    }

    @Override
    public Builder setApplicationName(String applicationName) {
      return (Builder) super.setApplicationName(applicationName);
    }

    @Override
    public Builder setSuppressPatternChecks(boolean suppressPatternChecks) {
      return (Builder) super.setSuppressPatternChecks(suppressPatternChecks);
    }

    @Override
    public Builder setSuppressRequiredParameterChecks(boolean suppressRequiredParameterChecks) {
      return (Builder) super.setSuppressRequiredParameterChecks(suppressRequiredParameterChecks);
    }

    @Override
    public Builder setSuppressAllChecks(boolean suppressAllChecks) {
      return (Builder) super.setSuppressAllChecks(suppressAllChecks);
    }

    /**
     * Set the {@link LocationendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setLocationendpointRequestInitializer(
        LocationendpointRequestInitializer locationendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(locationendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
