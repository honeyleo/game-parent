// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PBMessage.proto

package cn.gs.network.message;

public final class PBMessagePro {
  private PBMessagePro() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
  }
  public interface PBMessageOrBuilder
      extends com.google.protobuf.MessageOrBuilder {

    // optional int32 cmd = 1;
    /**
     * <code>optional int32 cmd = 1;</code>
     *
     * <pre>
     * 命令
     * </pre>
     */
    boolean hasCmd();
    /**
     * <code>optional int32 cmd = 1;</code>
     *
     * <pre>
     * 命令
     * </pre>
     */
    int getCmd();

    // optional int32 seq = 2;
    /**
     * <code>optional int32 seq = 2;</code>
     *
     * <pre>
     * 保留字段
     * </pre>
     */
    boolean hasSeq();
    /**
     * <code>optional int32 seq = 2;</code>
     *
     * <pre>
     * 保留字段
     * </pre>
     */
    int getSeq();

    // optional int32 playerId = 3;
    /**
     * <code>optional int32 playerId = 3;</code>
     *
     * <pre>
     * ID
     * </pre>
     */
    boolean hasPlayerId();
    /**
     * <code>optional int32 playerId = 3;</code>
     *
     * <pre>
     * ID
     * </pre>
     */
    int getPlayerId();

    // repeated int32 playerIds = 4;
    /**
     * <code>repeated int32 playerIds = 4;</code>
     */
    java.util.List<java.lang.Integer> getPlayerIdsList();
    /**
     * <code>repeated int32 playerIds = 4;</code>
     */
    int getPlayerIdsCount();
    /**
     * <code>repeated int32 playerIds = 4;</code>
     */
    int getPlayerIds(int index);

    // optional int32 status = 5;
    /**
     * <code>optional int32 status = 5;</code>
     *
     * <pre>
     * 状态
     * </pre>
     */
    boolean hasStatus();
    /**
     * <code>optional int32 status = 5;</code>
     *
     * <pre>
     * 状态
     * </pre>
     */
    int getStatus();

    // optional bytes data = 6;
    /**
     * <code>optional bytes data = 6;</code>
     *
     * <pre>
     * 数据
     * </pre>
     */
    boolean hasData();
    /**
     * <code>optional bytes data = 6;</code>
     *
     * <pre>
     * 数据
     * </pre>
     */
    com.google.protobuf.ByteString getData();

    // optional int32 sid = 7;
    /**
     * <code>optional int32 sid = 7;</code>
     *
     * <pre>
     * 唯一的SessionId
     * </pre>
     */
    boolean hasSid();
    /**
     * <code>optional int32 sid = 7;</code>
     *
     * <pre>
     * 唯一的SessionId
     * </pre>
     */
    int getSid();

    // optional bool is_succ = 8;
    /**
     * <code>optional bool is_succ = 8;</code>
     *
     * <pre>
     * 是否成功
     * </pre>
     */
    boolean hasIsSucc();
    /**
     * <code>optional bool is_succ = 8;</code>
     *
     * <pre>
     * 是否成功
     * </pre>
     */
    boolean getIsSucc();

    // optional bool is_return = 9 [default = true];
    /**
     * <code>optional bool is_return = 9 [default = true];</code>
     *
     * <pre>
     * 是否需要应答
     * </pre>
     */
    boolean hasIsReturn();
    /**
     * <code>optional bool is_return = 9 [default = true];</code>
     *
     * <pre>
     * 是否需要应答
     * </pre>
     */
    boolean getIsReturn();
  }
  /**
   * Protobuf type {@code NetProtocol.PBMessage}
   */
  public static final class PBMessage extends
      com.google.protobuf.GeneratedMessage
      implements PBMessageOrBuilder {
    // Use PBMessage.newBuilder() to construct.
    private PBMessage(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
      super(builder);
      this.unknownFields = builder.getUnknownFields();
    }
    private PBMessage(boolean noInit) { this.unknownFields = com.google.protobuf.UnknownFieldSet.getDefaultInstance(); }

    private static final PBMessage defaultInstance;
    public static PBMessage getDefaultInstance() {
      return defaultInstance;
    }

    public PBMessage getDefaultInstanceForType() {
      return defaultInstance;
    }

    private final com.google.protobuf.UnknownFieldSet unknownFields;
    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
        getUnknownFields() {
      return this.unknownFields;
    }
    private PBMessage(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      initFields();
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!parseUnknownField(input, unknownFields,
                                     extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
            case 8: {
              bitField0_ |= 0x00000001;
              cmd_ = input.readInt32();
              break;
            }
            case 16: {
              bitField0_ |= 0x00000002;
              seq_ = input.readInt32();
              break;
            }
            case 24: {
              bitField0_ |= 0x00000004;
              playerId_ = input.readInt32();
              break;
            }
            case 32: {
              if (!((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
                playerIds_ = new java.util.ArrayList<java.lang.Integer>();
                mutable_bitField0_ |= 0x00000008;
              }
              playerIds_.add(input.readInt32());
              break;
            }
            case 34: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              if (!((mutable_bitField0_ & 0x00000008) == 0x00000008) && input.getBytesUntilLimit() > 0) {
                playerIds_ = new java.util.ArrayList<java.lang.Integer>();
                mutable_bitField0_ |= 0x00000008;
              }
              while (input.getBytesUntilLimit() > 0) {
                playerIds_.add(input.readInt32());
              }
              input.popLimit(limit);
              break;
            }
            case 40: {
              bitField0_ |= 0x00000008;
              status_ = input.readInt32();
              break;
            }
            case 50: {
              bitField0_ |= 0x00000010;
              data_ = input.readBytes();
              break;
            }
            case 56: {
              bitField0_ |= 0x00000020;
              sid_ = input.readInt32();
              break;
            }
            case 64: {
              bitField0_ |= 0x00000040;
              isSucc_ = input.readBool();
              break;
            }
            case 72: {
              bitField0_ |= 0x00000080;
              isReturn_ = input.readBool();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e.getMessage()).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
          playerIds_ = java.util.Collections.unmodifiableList(playerIds_);
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return cn.gs.network.message.PBMessagePro.internal_static_NetProtocol_PBMessage_descriptor;
    }

    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return cn.gs.network.message.PBMessagePro.internal_static_NetProtocol_PBMessage_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              cn.gs.network.message.PBMessagePro.PBMessage.class, cn.gs.network.message.PBMessagePro.PBMessage.Builder.class);
    }

    public static com.google.protobuf.Parser<PBMessage> PARSER =
        new com.google.protobuf.AbstractParser<PBMessage>() {
      public PBMessage parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new PBMessage(input, extensionRegistry);
      }
    };

    @java.lang.Override
    public com.google.protobuf.Parser<PBMessage> getParserForType() {
      return PARSER;
    }

    private int bitField0_;
    // optional int32 cmd = 1;
    public static final int CMD_FIELD_NUMBER = 1;
    private int cmd_;
    /**
     * <code>optional int32 cmd = 1;</code>
     *
     * <pre>
     * 命令
     * </pre>
     */
    public boolean hasCmd() {
      return ((bitField0_ & 0x00000001) == 0x00000001);
    }
    /**
     * <code>optional int32 cmd = 1;</code>
     *
     * <pre>
     * 命令
     * </pre>
     */
    public int getCmd() {
      return cmd_;
    }

    // optional int32 seq = 2;
    public static final int SEQ_FIELD_NUMBER = 2;
    private int seq_;
    /**
     * <code>optional int32 seq = 2;</code>
     *
     * <pre>
     * 保留字段
     * </pre>
     */
    public boolean hasSeq() {
      return ((bitField0_ & 0x00000002) == 0x00000002);
    }
    /**
     * <code>optional int32 seq = 2;</code>
     *
     * <pre>
     * 保留字段
     * </pre>
     */
    public int getSeq() {
      return seq_;
    }

    // optional int32 playerId = 3;
    public static final int PLAYERID_FIELD_NUMBER = 3;
    private int playerId_;
    /**
     * <code>optional int32 playerId = 3;</code>
     *
     * <pre>
     * ID
     * </pre>
     */
    public boolean hasPlayerId() {
      return ((bitField0_ & 0x00000004) == 0x00000004);
    }
    /**
     * <code>optional int32 playerId = 3;</code>
     *
     * <pre>
     * ID
     * </pre>
     */
    public int getPlayerId() {
      return playerId_;
    }

    // repeated int32 playerIds = 4;
    public static final int PLAYERIDS_FIELD_NUMBER = 4;
    private java.util.List<java.lang.Integer> playerIds_;
    /**
     * <code>repeated int32 playerIds = 4;</code>
     */
    public java.util.List<java.lang.Integer>
        getPlayerIdsList() {
      return playerIds_;
    }
    /**
     * <code>repeated int32 playerIds = 4;</code>
     */
    public int getPlayerIdsCount() {
      return playerIds_.size();
    }
    /**
     * <code>repeated int32 playerIds = 4;</code>
     */
    public int getPlayerIds(int index) {
      return playerIds_.get(index);
    }

    // optional int32 status = 5;
    public static final int STATUS_FIELD_NUMBER = 5;
    private int status_;
    /**
     * <code>optional int32 status = 5;</code>
     *
     * <pre>
     * 状态
     * </pre>
     */
    public boolean hasStatus() {
      return ((bitField0_ & 0x00000008) == 0x00000008);
    }
    /**
     * <code>optional int32 status = 5;</code>
     *
     * <pre>
     * 状态
     * </pre>
     */
    public int getStatus() {
      return status_;
    }

    // optional bytes data = 6;
    public static final int DATA_FIELD_NUMBER = 6;
    private com.google.protobuf.ByteString data_;
    /**
     * <code>optional bytes data = 6;</code>
     *
     * <pre>
     * 数据
     * </pre>
     */
    public boolean hasData() {
      return ((bitField0_ & 0x00000010) == 0x00000010);
    }
    /**
     * <code>optional bytes data = 6;</code>
     *
     * <pre>
     * 数据
     * </pre>
     */
    public com.google.protobuf.ByteString getData() {
      return data_;
    }

    // optional int32 sid = 7;
    public static final int SID_FIELD_NUMBER = 7;
    private int sid_;
    /**
     * <code>optional int32 sid = 7;</code>
     *
     * <pre>
     * 唯一的SessionId
     * </pre>
     */
    public boolean hasSid() {
      return ((bitField0_ & 0x00000020) == 0x00000020);
    }
    /**
     * <code>optional int32 sid = 7;</code>
     *
     * <pre>
     * 唯一的SessionId
     * </pre>
     */
    public int getSid() {
      return sid_;
    }

    // optional bool is_succ = 8;
    public static final int IS_SUCC_FIELD_NUMBER = 8;
    private boolean isSucc_;
    /**
     * <code>optional bool is_succ = 8;</code>
     *
     * <pre>
     * 是否成功
     * </pre>
     */
    public boolean hasIsSucc() {
      return ((bitField0_ & 0x00000040) == 0x00000040);
    }
    /**
     * <code>optional bool is_succ = 8;</code>
     *
     * <pre>
     * 是否成功
     * </pre>
     */
    public boolean getIsSucc() {
      return isSucc_;
    }

    // optional bool is_return = 9 [default = true];
    public static final int IS_RETURN_FIELD_NUMBER = 9;
    private boolean isReturn_;
    /**
     * <code>optional bool is_return = 9 [default = true];</code>
     *
     * <pre>
     * 是否需要应答
     * </pre>
     */
    public boolean hasIsReturn() {
      return ((bitField0_ & 0x00000080) == 0x00000080);
    }
    /**
     * <code>optional bool is_return = 9 [default = true];</code>
     *
     * <pre>
     * 是否需要应答
     * </pre>
     */
    public boolean getIsReturn() {
      return isReturn_;
    }

    private void initFields() {
      cmd_ = 0;
      seq_ = 0;
      playerId_ = 0;
      playerIds_ = java.util.Collections.emptyList();
      status_ = 0;
      data_ = com.google.protobuf.ByteString.EMPTY;
      sid_ = 0;
      isSucc_ = false;
      isReturn_ = true;
    }
    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized != -1) return isInitialized == 1;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        output.writeInt32(1, cmd_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        output.writeInt32(2, seq_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        output.writeInt32(3, playerId_);
      }
      for (int i = 0; i < playerIds_.size(); i++) {
        output.writeInt32(4, playerIds_.get(i));
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        output.writeInt32(5, status_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        output.writeBytes(6, data_);
      }
      if (((bitField0_ & 0x00000020) == 0x00000020)) {
        output.writeInt32(7, sid_);
      }
      if (((bitField0_ & 0x00000040) == 0x00000040)) {
        output.writeBool(8, isSucc_);
      }
      if (((bitField0_ & 0x00000080) == 0x00000080)) {
        output.writeBool(9, isReturn_);
      }
      getUnknownFields().writeTo(output);
    }

    private int memoizedSerializedSize = -1;
    public int getSerializedSize() {
      int size = memoizedSerializedSize;
      if (size != -1) return size;

      size = 0;
      if (((bitField0_ & 0x00000001) == 0x00000001)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, cmd_);
      }
      if (((bitField0_ & 0x00000002) == 0x00000002)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(2, seq_);
      }
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(3, playerId_);
      }
      {
        int dataSize = 0;
        for (int i = 0; i < playerIds_.size(); i++) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(playerIds_.get(i));
        }
        size += dataSize;
        size += 1 * getPlayerIdsList().size();
      }
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(5, status_);
      }
      if (((bitField0_ & 0x00000010) == 0x00000010)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(6, data_);
      }
      if (((bitField0_ & 0x00000020) == 0x00000020)) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(7, sid_);
      }
      if (((bitField0_ & 0x00000040) == 0x00000040)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(8, isSucc_);
      }
      if (((bitField0_ & 0x00000080) == 0x00000080)) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(9, isReturn_);
      }
      size += getUnknownFields().getSerializedSize();
      memoizedSerializedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    protected java.lang.Object writeReplace()
        throws java.io.ObjectStreamException {
      return super.writeReplace();
    }

    public static cn.gs.network.message.PBMessagePro.PBMessage parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static cn.gs.network.message.PBMessagePro.PBMessage parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static cn.gs.network.message.PBMessagePro.PBMessage parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static cn.gs.network.message.PBMessagePro.PBMessage parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static cn.gs.network.message.PBMessagePro.PBMessage parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static cn.gs.network.message.PBMessagePro.PBMessage parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }
    public static cn.gs.network.message.PBMessagePro.PBMessage parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input);
    }
    public static cn.gs.network.message.PBMessagePro.PBMessage parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseDelimitedFrom(input, extensionRegistry);
    }
    public static cn.gs.network.message.PBMessagePro.PBMessage parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return PARSER.parseFrom(input);
    }
    public static cn.gs.network.message.PBMessagePro.PBMessage parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return PARSER.parseFrom(input, extensionRegistry);
    }

    public static Builder newBuilder() { return Builder.create(); }
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder(cn.gs.network.message.PBMessagePro.PBMessage prototype) {
      return newBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() { return newBuilder(this); }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code NetProtocol.PBMessage}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessage.Builder<Builder>
       implements cn.gs.network.message.PBMessagePro.PBMessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return cn.gs.network.message.PBMessagePro.internal_static_NetProtocol_PBMessage_descriptor;
      }

      protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return cn.gs.network.message.PBMessagePro.internal_static_NetProtocol_PBMessage_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                cn.gs.network.message.PBMessagePro.PBMessage.class, cn.gs.network.message.PBMessagePro.PBMessage.Builder.class);
      }

      // Construct using cn.gs.network.message.PBMessagePro.PBMessage.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessage.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders) {
        }
      }
      private static Builder create() {
        return new Builder();
      }

      public Builder clear() {
        super.clear();
        cmd_ = 0;
        bitField0_ = (bitField0_ & ~0x00000001);
        seq_ = 0;
        bitField0_ = (bitField0_ & ~0x00000002);
        playerId_ = 0;
        bitField0_ = (bitField0_ & ~0x00000004);
        playerIds_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
        status_ = 0;
        bitField0_ = (bitField0_ & ~0x00000010);
        data_ = com.google.protobuf.ByteString.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000020);
        sid_ = 0;
        bitField0_ = (bitField0_ & ~0x00000040);
        isSucc_ = false;
        bitField0_ = (bitField0_ & ~0x00000080);
        isReturn_ = true;
        bitField0_ = (bitField0_ & ~0x00000100);
        return this;
      }

      public Builder clone() {
        return create().mergeFrom(buildPartial());
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return cn.gs.network.message.PBMessagePro.internal_static_NetProtocol_PBMessage_descriptor;
      }

      public cn.gs.network.message.PBMessagePro.PBMessage getDefaultInstanceForType() {
        return cn.gs.network.message.PBMessagePro.PBMessage.getDefaultInstance();
      }

      public cn.gs.network.message.PBMessagePro.PBMessage build() {
        cn.gs.network.message.PBMessagePro.PBMessage result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public cn.gs.network.message.PBMessagePro.PBMessage buildPartial() {
        cn.gs.network.message.PBMessagePro.PBMessage result = new cn.gs.network.message.PBMessagePro.PBMessage(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        if (((from_bitField0_ & 0x00000001) == 0x00000001)) {
          to_bitField0_ |= 0x00000001;
        }
        result.cmd_ = cmd_;
        if (((from_bitField0_ & 0x00000002) == 0x00000002)) {
          to_bitField0_ |= 0x00000002;
        }
        result.seq_ = seq_;
        if (((from_bitField0_ & 0x00000004) == 0x00000004)) {
          to_bitField0_ |= 0x00000004;
        }
        result.playerId_ = playerId_;
        if (((bitField0_ & 0x00000008) == 0x00000008)) {
          playerIds_ = java.util.Collections.unmodifiableList(playerIds_);
          bitField0_ = (bitField0_ & ~0x00000008);
        }
        result.playerIds_ = playerIds_;
        if (((from_bitField0_ & 0x00000010) == 0x00000010)) {
          to_bitField0_ |= 0x00000008;
        }
        result.status_ = status_;
        if (((from_bitField0_ & 0x00000020) == 0x00000020)) {
          to_bitField0_ |= 0x00000010;
        }
        result.data_ = data_;
        if (((from_bitField0_ & 0x00000040) == 0x00000040)) {
          to_bitField0_ |= 0x00000020;
        }
        result.sid_ = sid_;
        if (((from_bitField0_ & 0x00000080) == 0x00000080)) {
          to_bitField0_ |= 0x00000040;
        }
        result.isSucc_ = isSucc_;
        if (((from_bitField0_ & 0x00000100) == 0x00000100)) {
          to_bitField0_ |= 0x00000080;
        }
        result.isReturn_ = isReturn_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof cn.gs.network.message.PBMessagePro.PBMessage) {
          return mergeFrom((cn.gs.network.message.PBMessagePro.PBMessage)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(cn.gs.network.message.PBMessagePro.PBMessage other) {
        if (other == cn.gs.network.message.PBMessagePro.PBMessage.getDefaultInstance()) return this;
        if (other.hasCmd()) {
          setCmd(other.getCmd());
        }
        if (other.hasSeq()) {
          setSeq(other.getSeq());
        }
        if (other.hasPlayerId()) {
          setPlayerId(other.getPlayerId());
        }
        if (!other.playerIds_.isEmpty()) {
          if (playerIds_.isEmpty()) {
            playerIds_ = other.playerIds_;
            bitField0_ = (bitField0_ & ~0x00000008);
          } else {
            ensurePlayerIdsIsMutable();
            playerIds_.addAll(other.playerIds_);
          }
          onChanged();
        }
        if (other.hasStatus()) {
          setStatus(other.getStatus());
        }
        if (other.hasData()) {
          setData(other.getData());
        }
        if (other.hasSid()) {
          setSid(other.getSid());
        }
        if (other.hasIsSucc()) {
          setIsSucc(other.getIsSucc());
        }
        if (other.hasIsReturn()) {
          setIsReturn(other.getIsReturn());
        }
        this.mergeUnknownFields(other.getUnknownFields());
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        cn.gs.network.message.PBMessagePro.PBMessage parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (cn.gs.network.message.PBMessagePro.PBMessage) e.getUnfinishedMessage();
          throw e;
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      // optional int32 cmd = 1;
      private int cmd_ ;
      /**
       * <code>optional int32 cmd = 1;</code>
       *
       * <pre>
       * 命令
       * </pre>
       */
      public boolean hasCmd() {
        return ((bitField0_ & 0x00000001) == 0x00000001);
      }
      /**
       * <code>optional int32 cmd = 1;</code>
       *
       * <pre>
       * 命令
       * </pre>
       */
      public int getCmd() {
        return cmd_;
      }
      /**
       * <code>optional int32 cmd = 1;</code>
       *
       * <pre>
       * 命令
       * </pre>
       */
      public Builder setCmd(int value) {
        bitField0_ |= 0x00000001;
        cmd_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 cmd = 1;</code>
       *
       * <pre>
       * 命令
       * </pre>
       */
      public Builder clearCmd() {
        bitField0_ = (bitField0_ & ~0x00000001);
        cmd_ = 0;
        onChanged();
        return this;
      }

      // optional int32 seq = 2;
      private int seq_ ;
      /**
       * <code>optional int32 seq = 2;</code>
       *
       * <pre>
       * 保留字段
       * </pre>
       */
      public boolean hasSeq() {
        return ((bitField0_ & 0x00000002) == 0x00000002);
      }
      /**
       * <code>optional int32 seq = 2;</code>
       *
       * <pre>
       * 保留字段
       * </pre>
       */
      public int getSeq() {
        return seq_;
      }
      /**
       * <code>optional int32 seq = 2;</code>
       *
       * <pre>
       * 保留字段
       * </pre>
       */
      public Builder setSeq(int value) {
        bitField0_ |= 0x00000002;
        seq_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 seq = 2;</code>
       *
       * <pre>
       * 保留字段
       * </pre>
       */
      public Builder clearSeq() {
        bitField0_ = (bitField0_ & ~0x00000002);
        seq_ = 0;
        onChanged();
        return this;
      }

      // optional int32 playerId = 3;
      private int playerId_ ;
      /**
       * <code>optional int32 playerId = 3;</code>
       *
       * <pre>
       * ID
       * </pre>
       */
      public boolean hasPlayerId() {
        return ((bitField0_ & 0x00000004) == 0x00000004);
      }
      /**
       * <code>optional int32 playerId = 3;</code>
       *
       * <pre>
       * ID
       * </pre>
       */
      public int getPlayerId() {
        return playerId_;
      }
      /**
       * <code>optional int32 playerId = 3;</code>
       *
       * <pre>
       * ID
       * </pre>
       */
      public Builder setPlayerId(int value) {
        bitField0_ |= 0x00000004;
        playerId_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 playerId = 3;</code>
       *
       * <pre>
       * ID
       * </pre>
       */
      public Builder clearPlayerId() {
        bitField0_ = (bitField0_ & ~0x00000004);
        playerId_ = 0;
        onChanged();
        return this;
      }

      // repeated int32 playerIds = 4;
      private java.util.List<java.lang.Integer> playerIds_ = java.util.Collections.emptyList();
      private void ensurePlayerIdsIsMutable() {
        if (!((bitField0_ & 0x00000008) == 0x00000008)) {
          playerIds_ = new java.util.ArrayList<java.lang.Integer>(playerIds_);
          bitField0_ |= 0x00000008;
         }
      }
      /**
       * <code>repeated int32 playerIds = 4;</code>
       */
      public java.util.List<java.lang.Integer>
          getPlayerIdsList() {
        return java.util.Collections.unmodifiableList(playerIds_);
      }
      /**
       * <code>repeated int32 playerIds = 4;</code>
       */
      public int getPlayerIdsCount() {
        return playerIds_.size();
      }
      /**
       * <code>repeated int32 playerIds = 4;</code>
       */
      public int getPlayerIds(int index) {
        return playerIds_.get(index);
      }
      /**
       * <code>repeated int32 playerIds = 4;</code>
       */
      public Builder setPlayerIds(
          int index, int value) {
        ensurePlayerIdsIsMutable();
        playerIds_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int32 playerIds = 4;</code>
       */
      public Builder addPlayerIds(int value) {
        ensurePlayerIdsIsMutable();
        playerIds_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int32 playerIds = 4;</code>
       */
      public Builder addAllPlayerIds(
          java.lang.Iterable<? extends java.lang.Integer> values) {
        ensurePlayerIdsIsMutable();
        super.addAll(values, playerIds_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int32 playerIds = 4;</code>
       */
      public Builder clearPlayerIds() {
        playerIds_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000008);
        onChanged();
        return this;
      }

      // optional int32 status = 5;
      private int status_ ;
      /**
       * <code>optional int32 status = 5;</code>
       *
       * <pre>
       * 状态
       * </pre>
       */
      public boolean hasStatus() {
        return ((bitField0_ & 0x00000010) == 0x00000010);
      }
      /**
       * <code>optional int32 status = 5;</code>
       *
       * <pre>
       * 状态
       * </pre>
       */
      public int getStatus() {
        return status_;
      }
      /**
       * <code>optional int32 status = 5;</code>
       *
       * <pre>
       * 状态
       * </pre>
       */
      public Builder setStatus(int value) {
        bitField0_ |= 0x00000010;
        status_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 status = 5;</code>
       *
       * <pre>
       * 状态
       * </pre>
       */
      public Builder clearStatus() {
        bitField0_ = (bitField0_ & ~0x00000010);
        status_ = 0;
        onChanged();
        return this;
      }

      // optional bytes data = 6;
      private com.google.protobuf.ByteString data_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>optional bytes data = 6;</code>
       *
       * <pre>
       * 数据
       * </pre>
       */
      public boolean hasData() {
        return ((bitField0_ & 0x00000020) == 0x00000020);
      }
      /**
       * <code>optional bytes data = 6;</code>
       *
       * <pre>
       * 数据
       * </pre>
       */
      public com.google.protobuf.ByteString getData() {
        return data_;
      }
      /**
       * <code>optional bytes data = 6;</code>
       *
       * <pre>
       * 数据
       * </pre>
       */
      public Builder setData(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  bitField0_ |= 0x00000020;
        data_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bytes data = 6;</code>
       *
       * <pre>
       * 数据
       * </pre>
       */
      public Builder clearData() {
        bitField0_ = (bitField0_ & ~0x00000020);
        data_ = getDefaultInstance().getData();
        onChanged();
        return this;
      }

      // optional int32 sid = 7;
      private int sid_ ;
      /**
       * <code>optional int32 sid = 7;</code>
       *
       * <pre>
       * 唯一的SessionId
       * </pre>
       */
      public boolean hasSid() {
        return ((bitField0_ & 0x00000040) == 0x00000040);
      }
      /**
       * <code>optional int32 sid = 7;</code>
       *
       * <pre>
       * 唯一的SessionId
       * </pre>
       */
      public int getSid() {
        return sid_;
      }
      /**
       * <code>optional int32 sid = 7;</code>
       *
       * <pre>
       * 唯一的SessionId
       * </pre>
       */
      public Builder setSid(int value) {
        bitField0_ |= 0x00000040;
        sid_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional int32 sid = 7;</code>
       *
       * <pre>
       * 唯一的SessionId
       * </pre>
       */
      public Builder clearSid() {
        bitField0_ = (bitField0_ & ~0x00000040);
        sid_ = 0;
        onChanged();
        return this;
      }

      // optional bool is_succ = 8;
      private boolean isSucc_ ;
      /**
       * <code>optional bool is_succ = 8;</code>
       *
       * <pre>
       * 是否成功
       * </pre>
       */
      public boolean hasIsSucc() {
        return ((bitField0_ & 0x00000080) == 0x00000080);
      }
      /**
       * <code>optional bool is_succ = 8;</code>
       *
       * <pre>
       * 是否成功
       * </pre>
       */
      public boolean getIsSucc() {
        return isSucc_;
      }
      /**
       * <code>optional bool is_succ = 8;</code>
       *
       * <pre>
       * 是否成功
       * </pre>
       */
      public Builder setIsSucc(boolean value) {
        bitField0_ |= 0x00000080;
        isSucc_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bool is_succ = 8;</code>
       *
       * <pre>
       * 是否成功
       * </pre>
       */
      public Builder clearIsSucc() {
        bitField0_ = (bitField0_ & ~0x00000080);
        isSucc_ = false;
        onChanged();
        return this;
      }

      // optional bool is_return = 9 [default = true];
      private boolean isReturn_ = true;
      /**
       * <code>optional bool is_return = 9 [default = true];</code>
       *
       * <pre>
       * 是否需要应答
       * </pre>
       */
      public boolean hasIsReturn() {
        return ((bitField0_ & 0x00000100) == 0x00000100);
      }
      /**
       * <code>optional bool is_return = 9 [default = true];</code>
       *
       * <pre>
       * 是否需要应答
       * </pre>
       */
      public boolean getIsReturn() {
        return isReturn_;
      }
      /**
       * <code>optional bool is_return = 9 [default = true];</code>
       *
       * <pre>
       * 是否需要应答
       * </pre>
       */
      public Builder setIsReturn(boolean value) {
        bitField0_ |= 0x00000100;
        isReturn_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>optional bool is_return = 9 [default = true];</code>
       *
       * <pre>
       * 是否需要应答
       * </pre>
       */
      public Builder clearIsReturn() {
        bitField0_ = (bitField0_ & ~0x00000100);
        isReturn_ = true;
        onChanged();
        return this;
      }

      // @@protoc_insertion_point(builder_scope:NetProtocol.PBMessage)
    }

    static {
      defaultInstance = new PBMessage(true);
      defaultInstance.initFields();
    }

    // @@protoc_insertion_point(class_scope:NetProtocol.PBMessage)
  }

  private static com.google.protobuf.Descriptors.Descriptor
    internal_static_NetProtocol_PBMessage_descriptor;
  private static
    com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internal_static_NetProtocol_PBMessage_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017PBMessage.proto\022\013NetProtocol\"\237\001\n\tPBMes" +
      "sage\022\013\n\003cmd\030\001 \001(\005\022\013\n\003seq\030\002 \001(\005\022\020\n\010player" +
      "Id\030\003 \001(\005\022\021\n\tplayerIds\030\004 \003(\005\022\016\n\006status\030\005 " +
      "\001(\005\022\014\n\004data\030\006 \001(\014\022\013\n\003sid\030\007 \001(\005\022\017\n\007is_suc" +
      "c\030\010 \001(\010\022\027\n\tis_return\030\t \001(\010:\004trueB\'\n\025cn.g" +
      "s.network.messageB\014PBMessageProH\001"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
      new com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner() {
        public com.google.protobuf.ExtensionRegistry assignDescriptors(
            com.google.protobuf.Descriptors.FileDescriptor root) {
          descriptor = root;
          internal_static_NetProtocol_PBMessage_descriptor =
            getDescriptor().getMessageTypes().get(0);
          internal_static_NetProtocol_PBMessage_fieldAccessorTable = new
            com.google.protobuf.GeneratedMessage.FieldAccessorTable(
              internal_static_NetProtocol_PBMessage_descriptor,
              new java.lang.String[] { "Cmd", "Seq", "PlayerId", "PlayerIds", "Status", "Data", "Sid", "IsSucc", "IsReturn", });
          return null;
        }
      };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
  }

  // @@protoc_insertion_point(outer_class_scope)
}
