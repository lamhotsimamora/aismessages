package dk.tbsalling.ais.messages;

import dk.tbsalling.ais.Decoder;
import dk.tbsalling.ais.exceptions.InvalidEncodedMessage;
import dk.tbsalling.ais.exceptions.UnsupportedMessageType;
import dk.tbsalling.ais.messages.types.AISMessageType;
import dk.tbsalling.ais.messages.types.MMSI;

/**
 * This message is used to pre-allocate TDMA slots within an AIS base station
 * network. It contains no navigational information, and is unlikely to be of
 * interest unless you are implementing or studying an AIS base station network.
 * 
 * @author tbsalling
 * 
 */
@SuppressWarnings("serial")
public class DataLinkManagement extends DecodedAISMessage {

	public DataLinkManagement(
			Integer repeatIndicator, MMSI sourceMmsi, Integer offsetNumber1,
			Integer reservedSlots1, Integer timeout1, Integer increment1,
			Integer offsetNumber2, Integer reservedSlots2, Integer timeout2,
			Integer increment2, Integer offsetNumber3, Integer reservedSlots3,
			Integer timeout3, Integer increment3, Integer offsetNumber4,
			Integer reservedSlots4, Integer timeout4, Integer increment4) {
		super(AISMessageType.DataLinkManagement, repeatIndicator, sourceMmsi);
		this.offsetNumber1 = offsetNumber1;
		this.reservedSlots1 = reservedSlots1;
		this.timeout1 = timeout1;
		this.increment1 = increment1;
		this.offsetNumber2 = offsetNumber2;
		this.reservedSlots2 = reservedSlots2;
		this.timeout2 = timeout2;
		this.increment2 = increment2;
		this.offsetNumber3 = offsetNumber3;
		this.reservedSlots3 = reservedSlots3;
		this.timeout3 = timeout3;
		this.increment3 = increment3;
		this.offsetNumber4 = offsetNumber4;
		this.reservedSlots4 = reservedSlots4;
		this.timeout4 = timeout4;
		this.increment4 = increment4;
	}
	public final Integer getOffsetNumber1() {
		return offsetNumber1;
	}
	public final Integer getReservedSlots1() {
		return reservedSlots1;
	}
	public final Integer getTimeout1() {
		return timeout1;
	}
	public final Integer getIncrement1() {
		return increment1;
	}
	public final Integer getOffsetNumber2() {
		return offsetNumber2;
	}
	public final Integer getReservedSlots2() {
		return reservedSlots2;
	}
	public final Integer getTimeout2() {
		return timeout2;
	}
	public final Integer getIncrement2() {
		return increment2;
	}
	public final Integer getOffsetNumber3() {
		return offsetNumber3;
	}
	public final Integer getReservedSlots3() {
		return reservedSlots3;
	}
	public final Integer getTimeout3() {
		return timeout3;
	}
	public final Integer getIncrement3() {
		return increment3;
	}
	public final Integer getOffsetNumber4() {
		return offsetNumber4;
	}
	public final Integer getReservedSlots4() {
		return reservedSlots4;
	}
	public final Integer getTimeout4() {
		return timeout4;
	}
	public final Integer getIncrement4() {
		return increment4;
	}
	
	public static DataLinkManagement fromEncodedMessage(EncodedAISMessage encodedMessage) {
		if (! encodedMessage.isValid())
			throw new InvalidEncodedMessage(encodedMessage);
		if (! encodedMessage.getMessageType().equals(AISMessageType.DataLinkManagement))
			throw new UnsupportedMessageType(encodedMessage.getMessageType().getCode());
			
		Integer repeatIndicator = Decoder.convertToUnsignedInteger(encodedMessage.getBits(6, 8));
		MMSI sourceMmsi = MMSI.valueOf(Decoder.convertToUnsignedLong(encodedMessage.getBits(8, 38)));

		Integer offsetNumber1 = Decoder.convertToUnsignedInteger(encodedMessage.getBits(40, 52));
		Integer reservedSlots1 = Decoder.convertToUnsignedInteger(encodedMessage.getBits(52, 56));
		Integer timeout1 = Decoder.convertToUnsignedInteger(encodedMessage.getBits(56, 59));
		Integer increment1 = Decoder.convertToUnsignedInteger(encodedMessage.getBits(59, 70));
		Integer offsetNumber2 = Decoder.convertToUnsignedInteger(encodedMessage.getBits(70, 82));
		Integer reservedSlots2 = Decoder.convertToUnsignedInteger(encodedMessage.getBits(82, 86));
		Integer timeout2 = Decoder.convertToUnsignedInteger(encodedMessage.getBits(86, 89));
		Integer increment2 = Decoder.convertToUnsignedInteger(encodedMessage.getBits(89, 100));
		Integer offsetNumber3 = Decoder.convertToUnsignedInteger(encodedMessage.getBits(100, 112));
		Integer reservedSlots3 = Decoder.convertToUnsignedInteger(encodedMessage.getBits(112,116));
		Integer timeout3 = Decoder.convertToUnsignedInteger(encodedMessage.getBits(116, 119));
		Integer increment3 = Decoder.convertToUnsignedInteger(encodedMessage.getBits(119, 130));
		Integer offsetNumber4 = Decoder.convertToUnsignedInteger(encodedMessage.getBits(130, 142));
		Integer reservedSlots4 = Decoder.convertToUnsignedInteger(encodedMessage.getBits(142, 146));
		Integer timeout4 = Decoder.convertToUnsignedInteger(encodedMessage.getBits(146, 149));
		Integer increment4 = Decoder.convertToUnsignedInteger(encodedMessage.getBits(149, 160));

		return new DataLinkManagement(repeatIndicator, sourceMmsi,
				offsetNumber1, reservedSlots1, timeout1, increment1,
				offsetNumber2, reservedSlots2, timeout2, increment2,
				offsetNumber3, reservedSlots3, timeout3, increment3,
				offsetNumber4, reservedSlots4, timeout4, increment4);
	}
	
	private final Integer offsetNumber1;
	private final Integer reservedSlots1;
	private final Integer timeout1;
	private final Integer increment1;
	private final Integer offsetNumber2;
	private final Integer reservedSlots2;
	private final Integer timeout2;
	private final Integer increment2;
	private final Integer offsetNumber3;
	private final Integer reservedSlots3;
	private final Integer timeout3;
	private final Integer increment3;
	private final Integer offsetNumber4;
	private final Integer reservedSlots4;
	private final Integer timeout4;
	private final Integer increment4;
}