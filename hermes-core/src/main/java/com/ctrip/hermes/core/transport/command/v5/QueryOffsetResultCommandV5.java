package com.ctrip.hermes.core.transport.command.v5;

import io.netty.buffer.ByteBuf;

import com.ctrip.hermes.core.bo.Offset;
import com.ctrip.hermes.core.transport.command.AbstractCommand;
import com.ctrip.hermes.core.transport.command.CommandType;
import com.ctrip.hermes.core.utils.HermesPrimitiveCodec;

public class QueryOffsetResultCommandV5 extends AbstractCommand {

	private static final long serialVersionUID = -3988734159665108642L;

	private Offset m_offset;

	public Offset getOffset() {
		return m_offset;
	}

	public QueryOffsetResultCommandV5() {
		this(null);
	}

	public QueryOffsetResultCommandV5(Offset offset) {
		super(CommandType.RESULT_QUERY_OFFSET_V5, 5);
		m_offset = offset;
	}

	@Override
	protected void parse0(ByteBuf buf) {
		HermesPrimitiveCodec codec = new HermesPrimitiveCodec(buf);
		m_offset = codec.readOffset();
	}

	@Override
	protected void toBytes0(ByteBuf buf) {
		HermesPrimitiveCodec codec = new HermesPrimitiveCodec(buf);
		codec.writeOffset(m_offset);
	}

}
