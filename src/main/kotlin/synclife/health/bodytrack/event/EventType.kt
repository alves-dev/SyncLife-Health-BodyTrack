package synclife.health.bodytrack.event

import java.util.*
import kotlin.reflect.KClass

enum class EventType(private val eventText: String, val eventBase: KClass<out EventBase>) {
    HEALTH_BODY_TRACK_SLEEP_V1(
        "HEALTH.BODY_TRACK.SLEEP.V1",
        EventSleep::class
    ); // https://github.com/alves-dev/SyncLife/blob/main/events.md#event-healthbody_tracksleepv1

    companion object {
        fun getEventClass(eventText: String): KClass<out EventBase> {
            return Arrays.stream(entries.toTypedArray())
                .filter { e -> e.eventText == eventText }.findFirst().get().eventBase
        }
    }
}