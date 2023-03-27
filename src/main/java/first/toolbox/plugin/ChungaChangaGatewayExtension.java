package first.toolbox.plugin;

import com.jetbrains.toolbox.feature.gateway.GatewayExtension;
import com.jetbrains.toolbox.feature.gateway.RemoteEnvironmentConsumer;
import com.jetbrains.toolbox.feature.gateway.RemoteEnvironmentPropertiesConsumer;
import com.jetbrains.toolbox.feature.gateway.RemoteProvider;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;

public class ChungaChangaGatewayExtension implements GatewayExtension {
    @Override
    public @NotNull RemoteProvider createRemoteProviderPluginInstance(
            @NotNull RemoteEnvironmentConsumer remoteEnvironmentConsumer,
            @NotNull RemoteEnvironmentPropertiesConsumer remoteEnvironmentPropertiesConsumer) {
        return new RemoteProvider() {
            @Override
            public @NotNull String getId() {
                return "chunga.changa";
            }

            @Override
            public @NotNull String getName() {
                return "Chunga Changa";
            }

            @Override
            public byte @NotNull [] getSvgIcon() {
                try (InputStream resourceAsStream = ChungaChangaGatewayExtension.class.getResourceAsStream("/icon.svg")) {
                    return resourceAsStream != null ? resourceAsStream.readAllBytes() : new byte[0];
                } catch (IOException e) {
                    return new byte[0];
                }
            }

            @Override
            public boolean canCreateNewEnvironments() {
                return false;
            }

            @Override
            public boolean isSingleEnvironment() {
                return false;
            }

            @Override
            public void close() {

            }
        };
    }
}
