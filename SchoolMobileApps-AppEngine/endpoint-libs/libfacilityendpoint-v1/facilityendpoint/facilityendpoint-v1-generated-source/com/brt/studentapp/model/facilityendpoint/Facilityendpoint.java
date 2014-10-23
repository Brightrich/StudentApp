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
 * on 2014-10-20 at 09:42:16 UTC 
 * Modify at your own risk.
 */

package com.brt.studentapp.model.facilityendpoint;

/**
 * Service definition for Facilityendpoint (v1).
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
 * This service uses {@link FacilityendpointRequestInitializer} to initialize global parameters via its
 * {@link Builder}.
 * </p>
 *
 * @since 1.3
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public class Facilityendpoint extends com.google.api.client.googleapis.services.json.AbstractGoogleJsonClient {

  // Note: Leave this static initializer at the top of the file.
  static {
    com.google.api.client.util.Preconditions.checkState(
        com.google.api.client.googleapis.GoogleUtils.MAJOR_VERSION == 1 &&
        com.google.api.client.googleapis.GoogleUtils.MINOR_VERSION >= 15,
        "You are currently running with version %s of google-api-client. " +
        "You need at least version 1.15 of google-api-client to run version " +
        "1.18.0-rc of the facilityendpoint library.", com.google.api.client.googleapis.GoogleUtils.VERSION);
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
  public static final String DEFAULT_SERVICE_PATH = "facilityendpoint/v1/";

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
  public Facilityendpoint(com.google.api.client.http.HttpTransport transport, com.google.api.client.json.JsonFactory jsonFactory,
      com.google.api.client.http.HttpRequestInitializer httpRequestInitializer) {
    this(new Builder(transport, jsonFactory, httpRequestInitializer));
  }

  /**
   * @param builder builder
   */
  Facilityendpoint(Builder builder) {
    super(builder);
  }

  @Override
  protected void initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest<?> httpClientRequest) throws java.io.IOException {
    super.initialize(httpClientRequest);
  }

  /**
   * Create a request for the method "getFacility".
   *
   * This request holds the parameters needed by the facilityendpoint server.  After setting any
   * optional parameters, call the {@link GetFacility#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public GetFacility getFacility(java.lang.Long id) throws java.io.IOException {
    GetFacility result = new GetFacility(id);
    initialize(result);
    return result;
  }

  public class GetFacility extends FacilityendpointRequest<com.brt.studentapp.model.facilityendpoint.model.Facility> {

    private static final String REST_PATH = "get_facility";

    /**
     * Create a request for the method "getFacility".
     *
     * This request holds the parameters needed by the the facilityendpoint server.  After setting any
     * optional parameters, call the {@link GetFacility#execute()} method to invoke the remote
     * operation. <p> {@link
     * GetFacility#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected GetFacility(java.lang.Long id) {
      super(Facilityendpoint.this, "GET", REST_PATH, null, com.brt.studentapp.model.facilityendpoint.model.Facility.class);
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
    public GetFacility setAlt(java.lang.String alt) {
      return (GetFacility) super.setAlt(alt);
    }

    @Override
    public GetFacility setFields(java.lang.String fields) {
      return (GetFacility) super.setFields(fields);
    }

    @Override
    public GetFacility setKey(java.lang.String key) {
      return (GetFacility) super.setKey(key);
    }

    @Override
    public GetFacility setOauthToken(java.lang.String oauthToken) {
      return (GetFacility) super.setOauthToken(oauthToken);
    }

    @Override
    public GetFacility setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetFacility) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetFacility setQuotaUser(java.lang.String quotaUser) {
      return (GetFacility) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetFacility setUserIp(java.lang.String userIp) {
      return (GetFacility) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public GetFacility setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public GetFacility set(String parameterName, Object value) {
      return (GetFacility) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "getFacilityByKey".
   *
   * This request holds the parameters needed by the facilityendpoint server.  After setting any
   * optional parameters, call the {@link GetFacilityByKey#execute()} method to invoke the remote
   * operation.
   *
   * @param kind
   * @param name
   * @return the request
   */
  public GetFacilityByKey getFacilityByKey(java.lang.String kind, java.lang.String name) throws java.io.IOException {
    GetFacilityByKey result = new GetFacilityByKey(kind, name);
    initialize(result);
    return result;
  }

  public class GetFacilityByKey extends FacilityendpointRequest<com.brt.studentapp.model.facilityendpoint.model.Facility> {

    private static final String REST_PATH = "get_facility_by_key";

    /**
     * Create a request for the method "getFacilityByKey".
     *
     * This request holds the parameters needed by the the facilityendpoint server.  After setting any
     * optional parameters, call the {@link GetFacilityByKey#execute()} method to invoke the remote
     * operation. <p> {@link GetFacilityByKey#initialize(com.google.api.client.googleapis.services.Abs
     * tractGoogleClientRequest)} must be called to initialize this instance immediately after
     * invoking the constructor. </p>
     *
     * @param kind
     * @param name
     * @since 1.13
     */
    protected GetFacilityByKey(java.lang.String kind, java.lang.String name) {
      super(Facilityendpoint.this, "GET", REST_PATH, null, com.brt.studentapp.model.facilityendpoint.model.Facility.class);
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
    public GetFacilityByKey setAlt(java.lang.String alt) {
      return (GetFacilityByKey) super.setAlt(alt);
    }

    @Override
    public GetFacilityByKey setFields(java.lang.String fields) {
      return (GetFacilityByKey) super.setFields(fields);
    }

    @Override
    public GetFacilityByKey setKey(java.lang.String key) {
      return (GetFacilityByKey) super.setKey(key);
    }

    @Override
    public GetFacilityByKey setOauthToken(java.lang.String oauthToken) {
      return (GetFacilityByKey) super.setOauthToken(oauthToken);
    }

    @Override
    public GetFacilityByKey setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (GetFacilityByKey) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public GetFacilityByKey setQuotaUser(java.lang.String quotaUser) {
      return (GetFacilityByKey) super.setQuotaUser(quotaUser);
    }

    @Override
    public GetFacilityByKey setUserIp(java.lang.String userIp) {
      return (GetFacilityByKey) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String kind;

    /**

     */
    public java.lang.String getKind() {
      return kind;
    }

    public GetFacilityByKey setKind(java.lang.String kind) {
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

    public GetFacilityByKey setName(java.lang.String name) {
      this.name = name;
      return this;
    }

    @Override
    public GetFacilityByKey set(String parameterName, Object value) {
      return (GetFacilityByKey) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "insertFacility".
   *
   * This request holds the parameters needed by the facilityendpoint server.  After setting any
   * optional parameters, call the {@link InsertFacility#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.brt.studentapp.model.facilityendpoint.model.Facility}
   * @return the request
   */
  public InsertFacility insertFacility(com.brt.studentapp.model.facilityendpoint.model.Facility content) throws java.io.IOException {
    InsertFacility result = new InsertFacility(content);
    initialize(result);
    return result;
  }

  public class InsertFacility extends FacilityendpointRequest<com.brt.studentapp.model.facilityendpoint.model.Facility> {

    private static final String REST_PATH = "insert_facility";

    /**
     * Create a request for the method "insertFacility".
     *
     * This request holds the parameters needed by the the facilityendpoint server.  After setting any
     * optional parameters, call the {@link InsertFacility#execute()} method to invoke the remote
     * operation. <p> {@link InsertFacility#initialize(com.google.api.client.googleapis.services.Abstr
     * actGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param content the {@link com.brt.studentapp.model.facilityendpoint.model.Facility}
     * @since 1.13
     */
    protected InsertFacility(com.brt.studentapp.model.facilityendpoint.model.Facility content) {
      super(Facilityendpoint.this, "POST", REST_PATH, content, com.brt.studentapp.model.facilityendpoint.model.Facility.class);
    }

    @Override
    public InsertFacility setAlt(java.lang.String alt) {
      return (InsertFacility) super.setAlt(alt);
    }

    @Override
    public InsertFacility setFields(java.lang.String fields) {
      return (InsertFacility) super.setFields(fields);
    }

    @Override
    public InsertFacility setKey(java.lang.String key) {
      return (InsertFacility) super.setKey(key);
    }

    @Override
    public InsertFacility setOauthToken(java.lang.String oauthToken) {
      return (InsertFacility) super.setOauthToken(oauthToken);
    }

    @Override
    public InsertFacility setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (InsertFacility) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public InsertFacility setQuotaUser(java.lang.String quotaUser) {
      return (InsertFacility) super.setQuotaUser(quotaUser);
    }

    @Override
    public InsertFacility setUserIp(java.lang.String userIp) {
      return (InsertFacility) super.setUserIp(userIp);
    }

    @Override
    public InsertFacility set(String parameterName, Object value) {
      return (InsertFacility) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "listFacility".
   *
   * This request holds the parameters needed by the facilityendpoint server.  After setting any
   * optional parameters, call the {@link ListFacility#execute()} method to invoke the remote
   * operation.
   *
   * @return the request
   */
  public ListFacility listFacility() throws java.io.IOException {
    ListFacility result = new ListFacility();
    initialize(result);
    return result;
  }

  public class ListFacility extends FacilityendpointRequest<com.brt.studentapp.model.facilityendpoint.model.CollectionResponseFacility> {

    private static final String REST_PATH = "list_facility";

    /**
     * Create a request for the method "listFacility".
     *
     * This request holds the parameters needed by the the facilityendpoint server.  After setting any
     * optional parameters, call the {@link ListFacility#execute()} method to invoke the remote
     * operation. <p> {@link
     * ListFacility#initialize(com.google.api.client.googleapis.services.AbstractGoogleClientRequest)}
     * must be called to initialize this instance immediately after invoking the constructor. </p>
     *
     * @since 1.13
     */
    protected ListFacility() {
      super(Facilityendpoint.this, "GET", REST_PATH, null, com.brt.studentapp.model.facilityendpoint.model.CollectionResponseFacility.class);
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
    public ListFacility setAlt(java.lang.String alt) {
      return (ListFacility) super.setAlt(alt);
    }

    @Override
    public ListFacility setFields(java.lang.String fields) {
      return (ListFacility) super.setFields(fields);
    }

    @Override
    public ListFacility setKey(java.lang.String key) {
      return (ListFacility) super.setKey(key);
    }

    @Override
    public ListFacility setOauthToken(java.lang.String oauthToken) {
      return (ListFacility) super.setOauthToken(oauthToken);
    }

    @Override
    public ListFacility setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (ListFacility) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public ListFacility setQuotaUser(java.lang.String quotaUser) {
      return (ListFacility) super.setQuotaUser(quotaUser);
    }

    @Override
    public ListFacility setUserIp(java.lang.String userIp) {
      return (ListFacility) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.String cursor;

    /**

     */
    public java.lang.String getCursor() {
      return cursor;
    }

    public ListFacility setCursor(java.lang.String cursor) {
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

    public ListFacility setLimit(java.lang.Integer limit) {
      this.limit = limit;
      return this;
    }

    @Override
    public ListFacility set(String parameterName, Object value) {
      return (ListFacility) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "removeFacility".
   *
   * This request holds the parameters needed by the facilityendpoint server.  After setting any
   * optional parameters, call the {@link RemoveFacility#execute()} method to invoke the remote
   * operation.
   *
   * @param id
   * @return the request
   */
  public RemoveFacility removeFacility(java.lang.Long id) throws java.io.IOException {
    RemoveFacility result = new RemoveFacility(id);
    initialize(result);
    return result;
  }

  public class RemoveFacility extends FacilityendpointRequest<Void> {

    private static final String REST_PATH = "remove_facility";

    /**
     * Create a request for the method "removeFacility".
     *
     * This request holds the parameters needed by the the facilityendpoint server.  After setting any
     * optional parameters, call the {@link RemoveFacility#execute()} method to invoke the remote
     * operation. <p> {@link RemoveFacility#initialize(com.google.api.client.googleapis.services.Abstr
     * actGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param id
     * @since 1.13
     */
    protected RemoveFacility(java.lang.Long id) {
      super(Facilityendpoint.this, "DELETE", REST_PATH, null, Void.class);
      this.id = com.google.api.client.util.Preconditions.checkNotNull(id, "Required parameter id must be specified.");
    }

    @Override
    public RemoveFacility setAlt(java.lang.String alt) {
      return (RemoveFacility) super.setAlt(alt);
    }

    @Override
    public RemoveFacility setFields(java.lang.String fields) {
      return (RemoveFacility) super.setFields(fields);
    }

    @Override
    public RemoveFacility setKey(java.lang.String key) {
      return (RemoveFacility) super.setKey(key);
    }

    @Override
    public RemoveFacility setOauthToken(java.lang.String oauthToken) {
      return (RemoveFacility) super.setOauthToken(oauthToken);
    }

    @Override
    public RemoveFacility setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (RemoveFacility) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public RemoveFacility setQuotaUser(java.lang.String quotaUser) {
      return (RemoveFacility) super.setQuotaUser(quotaUser);
    }

    @Override
    public RemoveFacility setUserIp(java.lang.String userIp) {
      return (RemoveFacility) super.setUserIp(userIp);
    }

    @com.google.api.client.util.Key
    private java.lang.Long id;

    /**

     */
    public java.lang.Long getId() {
      return id;
    }

    public RemoveFacility setId(java.lang.Long id) {
      this.id = id;
      return this;
    }

    @Override
    public RemoveFacility set(String parameterName, Object value) {
      return (RemoveFacility) super.set(parameterName, value);
    }
  }

  /**
   * Create a request for the method "updateFacility".
   *
   * This request holds the parameters needed by the facilityendpoint server.  After setting any
   * optional parameters, call the {@link UpdateFacility#execute()} method to invoke the remote
   * operation.
   *
   * @param content the {@link com.brt.studentapp.model.facilityendpoint.model.Facility}
   * @return the request
   */
  public UpdateFacility updateFacility(com.brt.studentapp.model.facilityendpoint.model.Facility content) throws java.io.IOException {
    UpdateFacility result = new UpdateFacility(content);
    initialize(result);
    return result;
  }

  public class UpdateFacility extends FacilityendpointRequest<com.brt.studentapp.model.facilityendpoint.model.Facility> {

    private static final String REST_PATH = "update_facility";

    /**
     * Create a request for the method "updateFacility".
     *
     * This request holds the parameters needed by the the facilityendpoint server.  After setting any
     * optional parameters, call the {@link UpdateFacility#execute()} method to invoke the remote
     * operation. <p> {@link UpdateFacility#initialize(com.google.api.client.googleapis.services.Abstr
     * actGoogleClientRequest)} must be called to initialize this instance immediately after invoking
     * the constructor. </p>
     *
     * @param content the {@link com.brt.studentapp.model.facilityendpoint.model.Facility}
     * @since 1.13
     */
    protected UpdateFacility(com.brt.studentapp.model.facilityendpoint.model.Facility content) {
      super(Facilityendpoint.this, "PUT", REST_PATH, content, com.brt.studentapp.model.facilityendpoint.model.Facility.class);
    }

    @Override
    public UpdateFacility setAlt(java.lang.String alt) {
      return (UpdateFacility) super.setAlt(alt);
    }

    @Override
    public UpdateFacility setFields(java.lang.String fields) {
      return (UpdateFacility) super.setFields(fields);
    }

    @Override
    public UpdateFacility setKey(java.lang.String key) {
      return (UpdateFacility) super.setKey(key);
    }

    @Override
    public UpdateFacility setOauthToken(java.lang.String oauthToken) {
      return (UpdateFacility) super.setOauthToken(oauthToken);
    }

    @Override
    public UpdateFacility setPrettyPrint(java.lang.Boolean prettyPrint) {
      return (UpdateFacility) super.setPrettyPrint(prettyPrint);
    }

    @Override
    public UpdateFacility setQuotaUser(java.lang.String quotaUser) {
      return (UpdateFacility) super.setQuotaUser(quotaUser);
    }

    @Override
    public UpdateFacility setUserIp(java.lang.String userIp) {
      return (UpdateFacility) super.setUserIp(userIp);
    }

    @Override
    public UpdateFacility set(String parameterName, Object value) {
      return (UpdateFacility) super.set(parameterName, value);
    }
  }

  /**
   * Builder for {@link Facilityendpoint}.
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

    /** Builds a new instance of {@link Facilityendpoint}. */
    @Override
    public Facilityendpoint build() {
      return new Facilityendpoint(this);
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
     * Set the {@link FacilityendpointRequestInitializer}.
     *
     * @since 1.12
     */
    public Builder setFacilityendpointRequestInitializer(
        FacilityendpointRequestInitializer facilityendpointRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(facilityendpointRequestInitializer);
    }

    @Override
    public Builder setGoogleClientRequestInitializer(
        com.google.api.client.googleapis.services.GoogleClientRequestInitializer googleClientRequestInitializer) {
      return (Builder) super.setGoogleClientRequestInitializer(googleClientRequestInitializer);
    }
  }
}
